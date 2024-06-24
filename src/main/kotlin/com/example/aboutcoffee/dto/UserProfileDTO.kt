package com.example.aboutcoffee.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Email

data class UserProfileDTO(
    var id: Long? = null,

    var name: String?,

    @field: Email
    var email: String? = null,

    @field:JsonProperty("picture_url")
    var pictureUrl: String? = null

)
