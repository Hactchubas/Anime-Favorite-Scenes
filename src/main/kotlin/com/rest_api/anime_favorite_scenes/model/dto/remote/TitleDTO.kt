package com.rest_api.anime_favorite_scenes.model.dto.remote

import com.fasterxml.jackson.annotation.JsonProperty

data class TitleDTO(
    @JsonProperty("native")
    val native: String,
    @JsonProperty("romaji")
    val romaji: String?,
    @JsonProperty("english")
    val english: String?
) {

}
