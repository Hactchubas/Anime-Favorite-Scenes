package com.rest_api.anime_favorite_scenes.service.local

import com.rest_api.anime_favorite_scenes.model.dto.local.SceneDTO

interface SceneService {
    fun getScenes(): List<SceneDTO>
    fun createScene(sceneDTO: SceneDTO): SceneDTO
    fun deleteScene(id: Long) : SceneDTO?
    fun likeScene(id: Long): SceneDTO?
    fun editDescription(id: Long, description: String): SceneDTO?
}