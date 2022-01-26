package com.amirhusseinsoori.data.mapper

import com.amirhusseinsoori.common.Constance.EMPTY_STRING
import com.amirhusseinsoori.domain.model.Characters
import com.amirhusseinsoori.domain.model.Episode
import com.amirhusseinsoori.domain.model.Info

import hb.rickandmortyapollo.GetCharactersQuery


fun GetCharactersQuery.Characters.mapToCategoryModel(): Characters {
    return Characters(
        info = info()!!.mapToInfoModel(),
        results = results()!!.mapToListResult()
    )
}

fun GetCharactersQuery.Info.mapToInfoModel(): Info {
    return Info(count = count()!!, next = next()!!, pages = pages()!!)
}

fun List<GetCharactersQuery.Result?>.mapToListResult(): List<com.amirhusseinsoori.domain.model.Result> {
    return map { it!!.mapToResult() }
}

fun GetCharactersQuery.Result.mapToResult(): com.amirhusseinsoori.domain.model.Result {
    return com.amirhusseinsoori.domain.model.Result(
        episode = episode()!!.mapToListEpisode(),
        id = id() ?: EMPTY_STRING,
        image = image() ?: EMPTY_STRING,
        name = name() ?: EMPTY_STRING,
    )
}

fun List<GetCharactersQuery.Episode?>.mapToListEpisode(): List<Episode> {
    return map { it!!.mapToEpisode() }
}

fun GetCharactersQuery.Episode.mapToEpisode(): Episode {
    return Episode(id = id() ?: EMPTY_STRING, name = name() ?: EMPTY_STRING)
}