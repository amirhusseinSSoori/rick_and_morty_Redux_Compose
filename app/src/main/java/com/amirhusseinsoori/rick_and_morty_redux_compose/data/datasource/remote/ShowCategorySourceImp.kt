package com.amirhusseinsoori.rick_and_morty_redux_compose.data.datasource.remote

import com.amirhusseinsoori.domain.datasource.ShowCategorySource
import com.amirhusseinsoori.domain.model.Characters
import com.amirhusseinsoori.rick_and_morty_redux_compose.data.mapper.mapToCategoryModel

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.hb.rickandmortyapollo.GetCharactersQuery
import javax.inject.Inject

class ShowCategorySourceImp  @Inject constructor(private val api: ApolloClient) :
    ShowCategorySource {
    override suspend fun getCharacters(): Characters {
        return api.query(GetCharactersQuery(Input.optional(1))).await().data!!.characters!!.mapToCategoryModel()
    }
}