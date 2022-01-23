package com.amirhusseinsoori.rick_and_morty_redux_compose.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.domain.model.Characters
import com.amirhusseinsoori.rick_and_morty_redux_compose.data.repository.RepositoryImp

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(val repositoryImp: RepositoryImp) : ViewModel() {

    private val _state = MutableStateFlow(State())
    val state=_state.asStateFlow()

    init {

        event()
    }

    private fun event(){
        viewModelScope.launch {
            repositoryImp.getCharacters().collect{
                when{
                     it.isSuccess()->{
                        _state.value=_state.value.copy(showDetails = it.data)
                    }
                }


        } }
    }



    data class State(
        val showDetails:
        Characters? = null
    )


}