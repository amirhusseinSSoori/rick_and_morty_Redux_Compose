package com.amirhusseinsoori.rick_and_morty_redux_compose.data.repository

import com.amirhusseinsoori.domain.datasource.ShowCategorySource
import com.amirhusseinsoori.domain.exception.CustomResult
import com.amirhusseinsoori.domain.model.Characters
import com.amirhusseinsoori.rick_and_morty_redux_compose.data.mapper.mapToCategoryModel

import com.hb.rickandmortyapollo.GetCharactersQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val network: ShowCategorySource) {

     fun getCharacters(): Flow<CustomResult<Characters>> = flow {
         emit(CustomResult.loading())
         emit(CustomResult.success(network.getCharacters()))
     }.catch { ex->
         emit(CustomResult.error(message = ex.message))
     }.flowOn(Dispatchers.IO)
}