package com.amirhusseinsoori.rick_and_morty_redux_compose.domin.model

data class Result(
    val episode: List<Episode>,
    val id: String,
    val image: String,
    val name: String
)