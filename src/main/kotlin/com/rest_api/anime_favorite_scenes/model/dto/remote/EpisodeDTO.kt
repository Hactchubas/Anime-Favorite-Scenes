package com.rest_api.anime_favorite_scenes.model.dto.remote

data class EpisodeDTO(
    val episodeString: String = "",
    val episodeArray: List<String> = emptyList()
) {
}