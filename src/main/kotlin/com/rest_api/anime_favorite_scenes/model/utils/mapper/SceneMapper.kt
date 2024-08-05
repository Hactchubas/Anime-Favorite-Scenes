package com.rest_api.anime_favorite_scenes.model.utils.mapper

import com.rest_api.anime_favorite_scenes.model.dto.local.SceneDTO
import com.rest_api.anime_favorite_scenes.model.entity.Scene
import org.springframework.stereotype.Service


@Service
class SceneMapper : Mapper<SceneDTO, Scene> {
    override fun toEntity(d: SceneDTO): Scene {
        return Scene(
            name = d.name,
            episode = d.episode,
            likes = d.likes,
            startTime =  d.startTime,
            sceneImgUrl =  d.sceneImage,
            description = d.description
        )
    }

    override fun toDTO(e: Scene): SceneDTO {
        return SceneDTO(
            e.id,
            e.name,
            e.episode,
            e.likes,
            e.startTime,
            e.sceneImgUrl,
            e.description
        )
    }
}