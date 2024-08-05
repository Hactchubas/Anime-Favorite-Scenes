package com.rest_api.anime_favorite_scenes.web.rest.controller

import anime_scenes.Allscenes
import com.rest_api.anime_favorite_scenes.model.dto.local.RequestDTO
import com.rest_api.anime_favorite_scenes.model.dto.local.SceneDTO
import com.rest_api.anime_favorite_scenes.model.utils.mapper.SceneMapper
import com.rest_api.anime_favorite_scenes.repository.SceneRepository
import com.rest_api.anime_favorite_scenes.service.local.SceneService
import com.rest_api.anime_favorite_scenes.service.remote.TraceMoeConnection
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@CrossOrigin
@RestController
@RequestMapping("/scenes", produces = [MediaType.APPLICATION_XML_VALUE])
class AnimeSceneControllerProtoBuf(
    private val sceneService: SceneService,
    private val traceMoeConnection: TraceMoeConnection,
    private val sceneRepository: SceneRepository,
    private val sceneMapper: SceneMapper
) {
    @GetMapping("/ranked", produces = [MediaType.APPLICATION_PROTOBUF_VALUE])
    fun getRankedScenes(): ResponseEntity<ByteArray> {
        val scenes = sceneRepository.findAll().toList().sortedByDescending {
            it.likes
        }.map {
            Allscenes.Scene.newBuilder()
                .setId(it.id.toDouble())
                .setName(it.name)
                .setEpisode(it.episode)
                .setLikes(it.likes.toDouble())
                .setStartTime(it.startTime.toDouble())
                .setSceneImage(it.sceneImgUrl)
                .setDescription(it.description)
                .build()
        }

        val allRankedScenes = Allscenes.AllRankedScenes.newBuilder().apply {
            scenes.forEach{
                addScenes(it)
            }
        }.build()
        val headers = HttpHeaders()
        return ResponseEntity(allRankedScenes.toByteArray(), headers, HttpStatus.OK)
    }

}