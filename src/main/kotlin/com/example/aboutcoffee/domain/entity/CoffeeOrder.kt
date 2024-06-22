package com.example.aboutcoffee.domain.entity

import jakarta.persistence.*

@Entity
class CoffeeOrder (
    orderNumber: String, // 주문 그룹
    coffeeId :Long,
    coffeeName :String,
    quantity: Int // 갯수

): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    var id: Long? = null

    @Column(name = "order_number")
    var orderNumber: String = orderNumber

    @Column(name = "coffee_id")
    var coffeeId : Long? = coffeeId

    @Column(name = "coffee_name")
    var coffeeName: String = coffeeName

    @Column(name = "quantity")
    var quantity: Int = quantity
}