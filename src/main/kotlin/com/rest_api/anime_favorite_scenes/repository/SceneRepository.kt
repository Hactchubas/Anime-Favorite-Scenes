package com.rest_api.anime_favorite_scenes.repository

import com.rest_api.anime_favorite_scenes.model.entity.Scene
import org.springframework.data.repository.CrudRepository

interface SceneRepository: CrudRepository<Scene, Long>{
    fun findByNameAndEpisodeAndStartTime(name: String, episode: String?, startTime: Long): List<Scene>
}