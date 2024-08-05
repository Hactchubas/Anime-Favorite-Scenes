package com.rest_api.anime_favorite_scenes.model.utils.mapper

import com.rest_api.anime_favorite_scenes.model.dto.local.SceneDTO
import com.rest_api.anime_favorite_scenes.model.dto.remote.TraceMoeResponseDTO
import com.rest_api.anime_favorite_scenes.model.utils.converter.SceneConverter

class TraceMoeMapper : Mapper<TraceMoeResponseDTO, List<SceneDTO>> {
    private val sceneConverter = SceneConverter()
    override fun toEntity(d: TraceMoeResponseDTO): List<SceneDTO> = d.result.map {
        sceneConverter.toLocal(it)
    }

    override fun toDTO(e: List<SceneDTO>): TraceMoeResponseDTO? = null
}