/*
 * Copyright (c) 2020 Contributors as noted in the AUTHORS.md file
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.shapestone.catalog.application

import com.shapestone.catalog.domain.model.{Catalog, CatalogItem}

object CatalogService {

  def createCatalog(catalog: Catalog): Unit = ???

  def getCatalog: Catalog = ???

  def updateCatalog(catalog: Catalog): Unit = ???

  def removeCatalog(catalogId: String): Unit = ???

  def addCatalogItem(catalogId: String, item: CatalogItem): Unit = ???

  def getCatalogItem(catalogId: String, item: CatalogItem): CatalogItem = ???

  def updateCatalogItem(catalogId: String, itemId: String): Unit = ???

  def removeCatalogItem(catalogId: String, itemId: String): Unit = ???
}
