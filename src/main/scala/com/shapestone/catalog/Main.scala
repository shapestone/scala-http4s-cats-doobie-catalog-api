/*
 * Copyright (c) 2021 Contributors as noted in the AUTHORS.md file
 *
 * This Source Code Form is subject to the terms of the MIT License
 */

package com.shapestone.catalog

import cats.effect.{ExitCode, IO, IOApp}
import com.typesafe.config.ConfigFactory

object Main extends IOApp  {
  val cfg = ConfigFactory.load(getClass.getClassLoader)
  val ip = cfg.getString("service.ip")

  override def run(args: List[String]): IO[ExitCode] =
    Server.stream[IO].compile.drain.as(ExitCode.Success)

}
