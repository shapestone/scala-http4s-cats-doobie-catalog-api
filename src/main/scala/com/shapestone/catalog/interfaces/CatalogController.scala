/*
 * Copyright (c) 2021 Contributors as noted in the AUTHORS.md file
 *
 * This Source Code Form is subject to the terms of the MIT License
 */

package com.shapestone.catalog.interfaces

import cats.effect._
import com.shapestone.catalog.domain.model.{Catalog, CatalogItem}
import io.circe.generic.auto._
import io.circe.syntax.EncoderOps
import org.http4s.HttpRoutes
import org.http4s.circe.jsonEncoder
import org.http4s.dsl.io._

object CatalogController {

  val catalogService: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case GET -> Root / "catalogs" / id =>
      Ok(Catalog(id, "furniture", Nil).asJson)

    case GET -> Root / "catalogs" / catalogId / "items" / itemId =>
      Ok(
        Catalog(catalogId, "furniture", List(
          CatalogItem(itemId, "chair")
        )).asJson
      )
  }
}
