/*
 * Copyright (c) 2021 Contributors as noted in the AUTHORS.md file
 *
 * This Source Code Form is subject to the terms of the MIT License
 */

package com.shapestone.catalog.application

import cats.Applicative
import cats.implicits.catsSyntaxApplicativeId
import com.shapestone.catalog.domain.model.{Catalog, CatalogItem}

trait CatalogService[F[_]]{
  def getCatalog(id: String): F[Catalog]
}

object CatalogService {
  implicit def apply[F[_]](implicit ev: CatalogService[F]): CatalogService[F] = ev

  def impl[F[_]: Applicative]: CatalogService[F] = new CatalogService[F]{
    def getCatalog(catalogId: String): F[Catalog] =
      Catalog(catalogId, "office supplies", List.empty).pure[F]
  }

  def createCatalog(catalog: Catalog): Unit = ()

  def getCatalog(catalogId: String): Catalog = {
    Catalog(catalogId, "office supplies", List.empty)
  }

  def updateCatalog(catalog: Catalog): Unit = ()

  def removeCatalog(catalogId: String): Unit = ()

  def addCatalogItem(catalogId: String, item: CatalogItem): Unit = ???

  def getCatalogItem(catalogId: String, item: CatalogItem): CatalogItem = ???

  def updateCatalogItem(catalogId: String, itemId: String): Unit = ???

  def removeCatalogItem(catalogId: String, itemId: String): Unit = ???
}
