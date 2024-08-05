package com.rest_api.anime_favorite_scenes.model.entity

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Scene(
    @Id
    @GeneratedValue
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    val id: Long = 0,
    val name: String,
    val episode: String?,
    var likes: Long,
    val startTime: Long,
    val sceneImgUrl: String,
    var description: String
)