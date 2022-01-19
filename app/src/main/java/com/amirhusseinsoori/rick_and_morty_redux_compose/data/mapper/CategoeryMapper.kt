package com.amirhusseinsoori.rick_and_morty_redux_compose.data.mapper

import androidx.lifecycle.Transformations.map
import com.amirhusseinsoori.rick_and_morty_redux_compose.domin.model.Characters
import com.amirhusseinsoori.rick_and_morty_redux_compose.domin.model.Episode
import com.amirhusseinsoori.rick_and_morty_redux_compose.domin.model.Info
import com.amirhusseinsoori.rick_and_morty_redux_compose.domin.model.Result
import com.hb.rickandmortyapollo.GetCharactersQuery


fun GetCharactersQuery.Characters.mapToCategoryModel(): Characters {
    return Characters(
        info = info!!.mapToInfoModel(),
        results = results!!.mapToListResult())
}
fun GetCharactersQuery.Info.mapToInfoModel(): Info {
    return Info(count = count!!, next = next!!, pages = pages!!)
}
fun List<GetCharactersQuery.Result?>.mapToListResult(): List<Result> {
    return map{ it!!.mapToResult() }
}
fun GetCharactersQuery.Result.mapToResult():Result{
    return Result(episode = episode!!.mapToListEpisode(),
        id=id!!,
        image = image!!,
        name = name!!,
        )
}
fun List<GetCharactersQuery.Episode?>.mapToListEpisode():List<Episode>{
    return map { it!!.mapToEpisode() }
}
fun GetCharactersQuery.Episode.mapToEpisode():Episode{
    return Episode(id=id!!, name = name!!)
}