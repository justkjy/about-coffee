package com.example.aboutcoffee.dto

import com.example.aboutcoffee.domain.constant.CoffeeType
import com.example.aboutcoffee.domain.entity.CoffeeMenu
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Column
import jakarta.validation.constraints.PositiveOrZero
import jakarta.validation.constraints.Size

data class CoffeeMenuDTO(
    var id: Long? = null,

    @field:JsonProperty("coffee_code")
    var coffeeCode : String = "",

    var category : CoffeeType? = null,

    @field:JsonProperty("coffee_name")
    var coffeeName: String = "",

    @field:Size(min = 0, max = 500)
    var coffeeImgUrl: String? = null,

    @field:Size(min = 0, max = 500)
    @field:JsonProperty("coffee_description")
    var coffeeDescription: String = "",

    @field:JsonProperty("coffee_price")
    var coffeePrice: Long? = null,

    @field:JsonProperty("userprofile_id")
    var userProfileId: Int? = null

)

fun CoffeeMenuDTO.toCoffeeMenu(): CoffeeMenu {
    val coffeeMenu = this
    return CoffeeMenu().apply {
        this.id = coffeeMenu.id
        this.coffeeCode = coffeeMenu.coffeeCode
        this.category = coffeeMenu.category
        this.coffeeName = coffeeMenu.coffeeName
        this.coffeeImgUrl = coffeeMenu.coffeeImgUrl
        this.coffeeDescription = coffeeMenu.coffeeDescription
        this.coffeePrice = coffeeMenu.coffeePrice
        this.userProfileId = coffeeMenu.userProfileId
    }
}