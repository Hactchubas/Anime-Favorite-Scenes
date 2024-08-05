package com.rest_api.anime_favorite_scenes.model.utils.converter

interface Converter<L, R> {
    fun toLocal(r: R): L?
    fun toRemote(l: L): R?
}