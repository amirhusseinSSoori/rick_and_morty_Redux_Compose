package com.amirhusseinsoori.data.datasource



import com.amirhusseinsoori.data.mapper.mapToCategoryModel
import com.amirhusseinsoori.domain.datasource.ShowCharactersSource
import com.amirhusseinsoori.domain.model.Characters
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.coroutines.await
import hb.rickandmortyapollo.GetCharactersQuery


import javax.inject.Inject

class ShowCharactersSourceImp  @Inject constructor(private val api: ApolloClient) :
    ShowCharactersSource {
    override suspend fun getCharacters(): Characters {
        return api.query(GetCharactersQuery(Input.optional(1))).await().data!!.characters()!!.mapToCategoryModel()
    }
}