package com.amirhusseinsoori.data.di

import com.amirhusseinsoori.common.Constance.baseUrl

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {


    @Singleton
    @Provides
    fun apolloClient(): ApolloClient =
        ApolloClient.builder().serverUrl(baseUrl).build()

}