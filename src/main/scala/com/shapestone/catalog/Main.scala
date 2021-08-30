/*
 * Copyright (c) 2021 Contributors as noted in the AUTHORS.md file
 *
 * This Source Code Form is subject to the terms of the MIT License
 */

package com.shapestone.catalog

import cats.effect._
import cats.implicits._
import org.http4s.implicits._
import com.shapestone.catalog.interfaces.{ApplicationController, CatalogController}
import org.http4s.blaze.server._

import scala.concurrent.ExecutionContext.global


object Main extends IOApp {
    private val routes = ApplicationController.applicationService <+> CatalogController.catalogService

  def run(args: List[String]): IO[ExitCode] =
    BlazeServerBuilder[IO](global)
      .bindHttp(8080, "localhost")
      .withHttpApp(routes.orNotFound)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)
}
