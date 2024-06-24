package com.example.aboutcoffee.domain.entity

import com.example.aboutcoffee.domain.constant.CoffeeType
import jakarta.persistence.*


@Entity
class CoffeeMenu(
    coffeeCode: String = "",
    category: CoffeeType? = null,
    coffeeName: String="",
    coffeeImgUrl: String = "",
    coffeeDescription: String = "",
    coffeePrice: Long? = null,
    userProfileId: Int? = null
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    var id: Long? = null

    @Column(name = "coffee_code")
    var coffeeCode: String = coffeeCode

    @Column(name = "coffee_type")
    var category : CoffeeType? = category

    @Column(name = "coffee_name")
    var coffeeName: String = coffeeName

    @Column(name = "coffee_url", length = 500)
    var coffeeImgUrl: String? = coffeeImgUrl

    @Column(name = "coffee_description", length = 500)
    var coffeeDescription: String = coffeeDescription

    // insert할때 500자 이하 제한 두자
    @Column(name = "coffee_price")
    var coffeePrice: Long? = coffeePrice

    @Column(name = "profile_id")
    var userProfileId: Int? = userProfileId
}