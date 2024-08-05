package com.rest_api.anime_favorite_scenes.model.dto.remote

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class RemoteSceneDTO(
    @JsonProperty("anilist")
    val anilist: AnilistDTO,
    @JsonProperty("filename")
    val fileName: String,
    @JsonProperty("episode")
    val episode: String?,
    @JsonProperty("from")
    val from: Long,
    @JsonProperty("to")
    val to: Long,
    @JsonProperty("similarity")
    val similarity: Long,
    @JsonProperty("video")
    val video: String,
    @JsonProperty("image")
    val image: String,

    ): Serializable
