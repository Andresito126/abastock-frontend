package com.softgenix.abastock.core.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class StoreRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AppRetrofit