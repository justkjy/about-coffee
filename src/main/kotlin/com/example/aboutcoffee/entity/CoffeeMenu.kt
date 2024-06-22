package com.example.aboutcoffee.entity

import com.example.aboutcoffee.constant.CoffeeType
import jakarta.persistence.*

@Entity
class CoffeeMenu(
    category: String,
    coffeeName: String,
    coffeeImgUrl: String = "",
    coffeeDescription: String = "",
    coffeePrice: UInt? = null,
    userProfileId: UInt? = null
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    var id: Long? = null

    @Column(name = "coffee_type")
    @Enumerated(value = EnumType.STRING)
    var category : CoffeeType? = CoffeeType.valueOf(category)

    @Column(name = "coffee_name")
    var coffeeName: String = coffeeName

    @Column(name = "coffee_url")
    var coffeeImgUrl: String? = coffeeImgUrl

    @Column(name = "coffee_description")
    var coffeeDescription: String = coffeeDescription

    @Column(name = "coffee_price")
    var coffeePrice: UInt? = coffeePrice

    @Column(name = "profile_id")
    var userProfileId: UInt? = userProfileId
}