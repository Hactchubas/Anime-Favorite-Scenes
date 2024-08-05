package com.rest_api.anime_favorite_scenes.model.dto.remote

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class TraceMoeResponseDTO(
    @JsonProperty("frameCount")
    val frameCount: Long,
    @JsonProperty("error")
    val error: String,
    @JsonProperty("result")
    val result: ArrayList<RemoteSceneDTO>
): Serializable