package com.rest_api.anime_favorite_scenes.model.dto.local

import com.fasterxml.jackson.databind.BeanDescription

data class SceneDTO(
    val id: Long,
    val name: String,
    val episode: String?,
    val likes: Long = 0,
    val startTime: Long,
    val sceneImage: String,
    var description: String,
)