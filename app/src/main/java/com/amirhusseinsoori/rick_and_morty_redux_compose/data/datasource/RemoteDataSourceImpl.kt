package com.amirhusseinsoori.rick_and_morty_redux_compose.data.datasource

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.hb.rickandmortyapollo.GetCharactersQuery
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(val network: ApolloClient) {
    suspend fun getCharacters(): Response<GetCharactersQuery.Data> {
        return network.query(GetCharactersQuery(Input.optional(1))).await()
    }
}