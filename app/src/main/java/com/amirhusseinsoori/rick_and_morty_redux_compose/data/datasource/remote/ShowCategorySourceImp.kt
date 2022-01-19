package com.amirhusseinsoori.rick_and_morty_redux_compose.data.datasource.remote

import com.amirhusseinsoori.rick_and_morty_redux_compose.domin.datasource.ShowCategorySource
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.hb.rickandmortyapollo.GetCharactersQuery
import javax.inject.Inject

class ShowCategorySourceImp  @Inject constructor(private val api: ApolloClient) : ShowCategorySource {
    override suspend fun getCharacters(): Response<GetCharactersQuery.Data> {
        return api.query(GetCharactersQuery(Input.optional(1))).await()
    }
}