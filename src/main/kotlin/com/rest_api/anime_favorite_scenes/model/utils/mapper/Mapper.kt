package com.rest_api.anime_favorite_scenes.model.utils.mapper

interface Mapper <D,E>{
    fun toEntity(d: D): E
    fun toDTO(e: E): D?
}