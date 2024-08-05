package com.rest_api.anime_favorite_scenes.service.remote

import com.fasterxml.jackson.databind.ObjectMapper
import com.rest_api.anime_favorite_scenes.model.dto.local.SceneDTO
import com.rest_api.anime_favorite_scenes.model.dto.remote.TraceMoeResponseDTO
import com.rest_api.anime_favorite_scenes.model.utils.mapper.TraceMoeMapper
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URI
import java.util.stream.Collectors

@Service
class TraceMoeConnection {
    private val baseUrl = "https://api.trace.moe/search?anilistInfo&url="

    fun getSceneInfo(imgUrl: String): SceneDTO? {
        val url = URI.create(baseUrl+imgUrl).toURL()
        var sceneDTO : SceneDTO? = null
        try {
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            val reader = BufferedReader(InputStreamReader(conn.inputStream))
            val json = reader.lines().collect(Collectors.joining())
            reader.close()


            println(json)
            val objectMapper = ObjectMapper()
            val result = objectMapper.readValue(json, TraceMoeResponseDTO::class.java)

            val traceMoeMapper = TraceMoeMapper()
            sceneDTO = traceMoeMapper.toEntity(result).first()
        } catch (e: Error){
            println(e.message)
        }
        return sceneDTO
    }


}