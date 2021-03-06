package com.amirhusseinsoori.data.repository

import com.amirhusseinsoori.domain.datasource.ShowCharactersSource
import com.amirhusseinsoori.domain.exception.CustomResult
import com.amirhusseinsoori.domain.model.Characters
import com.amirhusseinsoori.domain.repository.CharactersRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CharactersRepositoryImp @Inject constructor(private val network: ShowCharactersSource):
    CharactersRepository {
    override fun getCharacters(): Flow<CustomResult<Characters>> = flow {
         emit(CustomResult.loading())
         emit(CustomResult.success(network.getCharacters()))
     }.catch { ex->
         emit(CustomResult.error(message = ex.message))
     }.flowOn(Dispatchers.IO)
}