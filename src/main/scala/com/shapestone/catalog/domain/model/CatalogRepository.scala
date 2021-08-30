/*
 * Copyright (c) 2021 Contributors as noted in the AUTHORS.md file
 *
 * This Source Code Form is subject to the terms of the MIT License
 */

package com.shapestone.catalog.domain.model

trait CatalogRepository {

  def createCatalog(catalog: Catalog): Unit

  def getCatalog: Catalog

  def updateCatalog(catalog: Catalog): Unit

  def removeCatalog(catalogId: String): Unit

  def nextCatalogId: String;
}
