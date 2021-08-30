/*
 * Copyright (c) 2021 Contributors as noted in the AUTHORS.md file
 *
 * This Source Code Form is subject to the terms of the MIT License
 */

package com.shapestone.catalog.domain.model

trait CatalogItemRepository {

  def addCatalogItem(catalogId: String, item: CatalogItem): Unit

  def getCatalogItem(catalogId: String, item: CatalogItem): CatalogItem

  def updateCatalogItem(catalogId: String, itemId: String): Unit

  def removeCatalogItem(catalogId: String, itemId: String): Unit

  def nextCatalogItemId: String;
}
