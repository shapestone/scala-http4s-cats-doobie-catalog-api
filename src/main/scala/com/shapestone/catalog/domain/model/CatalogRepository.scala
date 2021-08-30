/*
 * Copyright (c) 2020 Contributors as noted in the AUTHORS.md file
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.shapestone.catalog.domain.model

trait CatalogRepository {

  def createCatalog(catalog: Catalog): Unit

  def getCatalog: Catalog

  def updateCatalog(catalog: Catalog): Unit

  def removeCatalog(catalogId: String): Unit

  def nextCatalogId: String;
}
