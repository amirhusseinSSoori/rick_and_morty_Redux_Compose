package com.amirhusseinsoori.rick_and_morty_redux_compose.domin.datasource

import com.apollographql.apollo.api.Response
import com.hb.rickandmortyapollo.GetCharactersQuery

interface ShowCategorySource {
    suspend fun getCharacters(): Response<GetCharactersQuery.Data>
}