package com.rest_api.anime_favorite_scenes.service.local

import com.rest_api.anime_favorite_scenes.model.dto.local.SceneDTO
import com.rest_api.anime_favorite_scenes.model.entity.Scene
import com.rest_api.anime_favorite_scenes.model.utils.mapper.SceneMapper
import com.rest_api.anime_favorite_scenes.repository.SceneRepository
import org.springframework.stereotype.Service


@Service
class SceneServiceImpl(
    private val sceneRepository: SceneRepository,
    private val sceneMapper: SceneMapper
) : SceneService {
    override fun getScenes(): List<SceneDTO> {
        return sceneRepository.findAll().toList().map {
            sceneMapper.toDTO(it)
        }
    }

    override fun createScene(sceneDTO: SceneDTO): SceneDTO {
        val scene = sceneMapper.toEntity(sceneDTO)
        val exists = sceneRepository.findByNameAndEpisodeAndStartTime(scene.name, scene.episode, scene.startTime)
        if (exists.isEmpty()){
            sceneRepository.save(scene)
        } else{
            return sceneMapper.toDTO(exists[0])
        }
        return sceneMapper.toDTO(scene)
    }

    override fun deleteScene(id: Long): SceneDTO? {
        if(sceneRepository.existsById(id)) {
            val scene = sceneRepository.findById(id).get()
            sceneRepository.delete(scene)
            return sceneMapper.toDTO(scene)
        }
        return null
    }

    override fun likeScene(id: Long): SceneDTO? {
        if (sceneRepository.existsById(id)){
            val scene = sceneRepository.findById(id).get()
            scene.likes++
            sceneRepository.save(scene)

            return sceneMapper.toDTO(scene)
        }
        return null
    }

    override fun editDescription(id: Long, description: String): SceneDTO? {
        if (sceneRepository.existsById(id)){
            val scene = sceneRepository.findById(id).get()
            scene.description = description
            sceneRepository.save(scene)

            return sceneMapper.toDTO(scene)
        }
        return null
    }
}