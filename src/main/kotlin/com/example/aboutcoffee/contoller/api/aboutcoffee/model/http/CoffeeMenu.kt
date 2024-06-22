package com.example.aboutcoffee.contoller.api.aboutcoffee.model.http

import jakarta.validation.constraints.NotBlank

data class CoffeeMenu(

    var coffeeId: Int? = null,

    var coffeeName: String? = null,

    var description: String? = null,

    var price: Int? = null,

    var imageUrl: String? = null,
)
