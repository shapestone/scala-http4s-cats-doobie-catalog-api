package com.shapestone.catalog.interfaces

import cats.data.{Kleisli, OptionT}
import cats.effect.IO
import org.http4s.dsl.io.{Forbidden, http4sForbiddenSyntax}
import org.http4s.server.AuthMiddleware
import org.http4s.{AuthedRoutes, BasicCredentials, Request}
import org.typelevel.ci.CIString

object BasicAuth {
  object AnyError extends Error

  case class User(userName: String)

  def validateCredentials(credentials: BasicCredentials): Boolean = {
    credentials.username == "foo" && credentials.password == "bar"
  }

  def basicAuthCredentials(request: Request[IO]): Option[BasicCredentials] = {
    val header = request.headers.get(CIString("Authorization"))
    header match {
      case Some(h) => basicAuthDecoder(h.head.value)
      case None => None
    }
  }

  def basicAuthDecoder(header: String): Option[BasicCredentials] = {
    val base64 = header.split(" ").last
    Some(BasicCredentials(base64))
  }

  val authUser: Kleisli[IO, Request[IO], Either[String,User]] =
    Kleisli(request => {
      val basicCredentials = BasicAuth.basicAuthCredentials(request)
      basicCredentials match {
        case None                           => IO(Left("No Authorization header provided"))
        case Some(c) if BasicAuth.validateCredentials(c) => IO(Right(User(c.username)))
        case _                              => IO(Left("Invalid Authorization credentials"))
      }
    })

  val onFailure: AuthedRoutes[String, IO] =
     Kleisli(req => OptionT.liftF(Forbidden(req.context)))

  val middleware: AuthMiddleware[IO, User] =
    AuthMiddleware(authUser, onFailure)
}
