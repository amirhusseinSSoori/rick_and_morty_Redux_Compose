package com.amirhusseinsoori.domain.repository

import com.amirhusseinsoori.domain.exception.CustomResult
import com.amirhusseinsoori.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun getCharacters(): Flow<CustomResult<Characters>>
}