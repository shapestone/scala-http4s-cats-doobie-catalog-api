/*
 * Copyright (c) 2021 Contributors as noted in the AUTHORS.md file
 *
 * This Source Code Form is subject to the terms of the MIT License
 */

package com.shapestone.catalog.domain.model

case class Catalog(id: String, name: String, items: List[CatalogItem])
