package com.amirhusseinsoori.rick_and_morty_redux_compose.data.repository

import com.amirhusseinsoori.rick_and_morty_redux_compose.domin.datasource.ShowCategorySource
import com.amirhusseinsoori.rick_and_morty_redux_compose.domin.exception.Result
import com.hb.rickandmortyapollo.GetCharactersQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val network: ShowCategorySource) {

     fun getCharacters(): Flow<Result<GetCharactersQuery.Data>> = flow {
         emit(Result.loading())
         emit(Result.success(network.getCharacters().data!!))
     }.catch { ex->
         emit(Result.error(message = ex.message))
     }.flowOn(Dispatchers.IO)
}