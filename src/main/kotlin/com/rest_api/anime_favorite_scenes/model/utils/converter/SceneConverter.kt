package com.rest_api.anime_favorite_scenes.model.utils.converter

import com.rest_api.anime_favorite_scenes.model.dto.local.SceneDTO
import com.rest_api.anime_favorite_scenes.model.dto.remote.RemoteSceneDTO

class SceneConverter: Converter<SceneDTO, RemoteSceneDTO> {
    override fun toLocal(r: RemoteSceneDTO): SceneDTO = SceneDTO(
        id = -1,
        name = r.anilist.title.english ?: r.anilist.title.romaji ?: r.anilist.title.native,
        episode = r.episode,
        startTime = r.from,
        sceneImage = r.image,
        description = ""
    )

    override fun toRemote(l: SceneDTO): RemoteSceneDTO? = null
}