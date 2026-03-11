package com.softgenix.abastock.features.authentication.data.datasources.remote.mapper

import com.softgenix.abastock.features.authentication.data.datasources.remote.models.AuthTokensDto
import com.softgenix.abastock.features.authentication.domain.entities.AuthTokens

fun AuthTokensDto.toDomain(): AuthTokens {
    return AuthTokens(
        accessToken = this.token.accessToken,
        refreshToken = this.token.refreshToken
    )
}