package com.softgenix.abastock.core.navigation

import kotlinx.serialization.Serializable

// auth
@Serializable
object Login

@Serializable
object RegisterGraph
@Serializable
object Register

@Serializable
object SuccessRegister

// inventario

@Serializable
object Inventory
@Serializable
data class CreateProduct(val barcode: String? = null)

//home
@Serializable
object Home

//purchases

@Serializable
object PurchaseScanner
@Serializable
object PurchaseEmptyCart
@Serializable
object PurchaseSummary
@Serializable
data class AddToCart (val barcode: String)

//sales

@Serializable object SalesBase
@Serializable object Cart
@Serializable object ProductPicker
@Serializable data class Success(val total: Double)