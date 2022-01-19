package com.amirhusseinsoori.rick_and_morty_redux_compose.data.di

import com.amirhusseinsoori.rick_and_morty_redux_compose.common.Constance.baseUrl
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