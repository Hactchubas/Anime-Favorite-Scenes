package com.rest_api.anime_favorite_scenes.web.rest.controller

import com.rest_api.anime_favorite_scenes.model.dto.local.RequestDTO
import com.rest_api.anime_favorite_scenes.model.dto.local.SceneDTO
import com.rest_api.anime_favorite_scenes.model.utils.mapper.SceneMapper
import com.rest_api.anime_favorite_scenes.repository.SceneRepository
import com.rest_api.anime_favorite_scenes.service.local.SceneService
import com.rest_api.anime_favorite_scenes.service.remote.TraceMoeConnection
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/xml/scenes", produces = [MediaType.APPLICATION_XML_VALUE])
class AnimeSceneControllerXML(
    private val sceneService: SceneService,
    private val traceMoeConnection: TraceMoeConnection,
    private val sceneRepository: SceneRepository,
    private val sceneMapper: SceneMapper
) {

    @GetMapping
    fun getScenes() : List<SceneDTO> = sceneRepository.findAll().toList().map {
        sceneMapper.toDTO(it)
    }

    @PostMapping("/new")
    fun findCreateScene(@RequestBody requestDTO: RequestDTO) : SceneDTO? {
        val imgUrl = requestDTO.imgUrl ?: return null
        val sceneDTO = traceMoeConnection.getSceneInfo(imgUrl)
        if (sceneDTO != null){
            sceneDTO.description = requestDTO.description ?: return null
            return sceneService.createScene(sceneDTO)
        }
        return null
    }

    @DeleteMapping("remove/{id}")
    fun removeScene(@PathVariable id: Long) : SceneDTO? {
        return sceneService.deleteScene(id)
    }

    @PutMapping("like/{id}")
    fun likeScene(@PathVariable id: Long): SceneDTO?{
        return  sceneService.likeScene(id)
    }

    @PutMapping("description/{id}")
    fun likeScene(@PathVariable id: Long, @RequestBody requestDTO: RequestDTO): SceneDTO?{
        val description = requestDTO.description ?: return null
        return  sceneService.editDescription(id, description)
    }



}