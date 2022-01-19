package com.amirhusseinsoori.rick_and_morty_redux_compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.amirhusseinsoori.rick_and_morty_redux_compose.ui.characters.CharactersViewModel
import com.amirhusseinsoori.rick_and_morty_redux_compose.ui.theme.Rick_and_morty_Redux_ComposeTheme
import com.hb.rickandmortyapollo.GetCharactersQuery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Rick_and_morty_Redux_ComposeTheme {

                val viewModel: CharactersViewModel = hiltViewModel()
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    viewModel.state.collectAsState().let {
                        it.value.showDetails?.let {data->
                            Log.e("test Data", "onCreate: ${data.results}", )
                        }

                    }

                }
            }
        }
    }
}

