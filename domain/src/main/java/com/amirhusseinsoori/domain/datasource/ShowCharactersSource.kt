package com.amirhusseinsoori.domain.datasource

import com.amirhusseinsoori.domain.model.Characters


interface ShowCharactersSource {
    suspend fun getCharacters(): Characters
}