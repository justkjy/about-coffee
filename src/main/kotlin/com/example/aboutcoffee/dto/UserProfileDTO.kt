package com.example.aboutcoffee.dto

import com.example.aboutcoffee.domain.entity.UserProfile
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class UserProfileDTO(
    var id: Long? = null,

    @NotBlank(message = "name is required")
    var name: String,

    @NotBlank(message = "email is required")
    @field: Email
    var email: String,

    @field:JsonProperty("picture_url")
    var pictureUrl: String? = null

)

fun UserProfileDTO.toUserProfile() : UserProfile {
    val userProfile = this
    return UserProfile().apply {
        this.id = userProfile.id
        this.email = userProfile.email
        this.pictureUrl = userProfile.pictureUrl
        this.name = userProfile.name
    }
}
