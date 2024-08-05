package com.rest_api.anime_favorite_scenes.model.dto.remote

import com.fasterxml.jackson.annotation.JsonProperty

data class AnilistDTO(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("idMal")
    val idMal: Long,
    @JsonProperty("title")
    val title: TitleDTO,
    @JsonProperty("synonyms")
    val synonyms: List<String>,
    @JsonProperty("isAdult")
    val isAdult: Boolean
) {

}
