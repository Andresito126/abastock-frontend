// core/data/local/UserSession.kt
package com.softgenix.abastock.core.data.local

data class UserSession(
    val userId: String,
    val email: String,
    val name: String,
    val storeId: String?,
    val storeName: String?
)