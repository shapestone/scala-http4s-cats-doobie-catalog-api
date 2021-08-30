package com.shapestone.catalog.interfaces

import cats.effect._
import org.http4s.HttpRoutes
import org.http4s.dsl.io._

object ApplicationController {

  val applicationService: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case GET -> Root / "health" => Ok("HEALTH")

    case GET -> Root / "ping" => Ok("PING")

  }
}
