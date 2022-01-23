package com.amirhusseinsoori.domain.datasource

import com.amirhusseinsoori.domain.model.Characters


interface ShowCategorySource {
    suspend fun getCharacters(): Characters
}