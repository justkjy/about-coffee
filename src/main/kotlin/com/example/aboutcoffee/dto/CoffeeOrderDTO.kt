package com.example.aboutcoffee.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Column

data class CoffeeOrderDTO(
    var id: Long? = null,

    @field:JsonProperty("order_Number")
    var orderNumber: String = "",

    @field:JsonProperty("coffee_code")
    var coffeeCode : String? = "",

    @field:JsonProperty("coffee_name")
    var coffeeName: String = "",

    var quantity: Int = 0,

    @field:JsonProperty("order_completed")
    var orderCompleted : Boolean = false
)
