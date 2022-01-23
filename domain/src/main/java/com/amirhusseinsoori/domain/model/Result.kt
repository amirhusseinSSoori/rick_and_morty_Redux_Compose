package com.amirhusseinsoori.domain.model

import com.amirhusseinsoori.domain.model.Episode

data class Result(
    val episode: List<Episode>,
    val id: String,
    val image: String,
    val name: String
)