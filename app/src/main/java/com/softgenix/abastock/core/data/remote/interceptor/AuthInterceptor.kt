package com.softgenix.abastock.core.data.remote.interceptor

import com.softgenix.abastock.core.data.local.TokenManager
import com.softgenix.abastock.core.data.remote.api.RefreshTokenApi
import com.softgenix.abastock.core.data.remote.models.RefreshTokenRequestDto
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val tokenManager: TokenManager,
    private val refreshTokenApi: RefreshTokenApi
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${tokenManager.getAccessToken()}")
            .build()

        val response = chain.proceed(request)

        if (response.code == 401) {
            response.close()
            return tryRefresh(chain)
        }

        return response
    }

    private fun tryRefresh(chain: Interceptor.Chain): Response {
        val refreshToken = tokenManager.getRefreshToken()
            ?: return chain.proceed(chain.request())

        return try {
            val refreshResponse = runBlocking {
                refreshTokenApi.refresh(RefreshTokenRequestDto(refreshToken))
            }

            tokenManager.saveTokens(
                accessToken = refreshResponse.accessToken,
                refreshToken = refreshResponse.newRefreshToken
            )

            chain.proceed(
                chain.request().newBuilder()
                    .header("Authorization", "Bearer ${refreshResponse.accessToken}")
                    .build()
            )
        } catch (e: Exception) {
            // Refresh falló, limpiar sesión
            tokenManager.clear()
            chain.proceed(chain.request())
        }
    }
}