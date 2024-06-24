package com.example.aboutcoffee.domain.entity

import jakarta.persistence.*

@Entity
class CoffeeOrder (
    orderNumber: String, // 주문 그룹

    coffeeCode :Long,

    coffeeName :String,

    quantity: Int // 갯수

): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    var id: Long? = null

    // 주문 번호
    @Column(name = "order_number")
    var orderNumber: String = orderNumber

    @Column(name = "coffee_code")
    var coffeeCode : Long? = coffeeCode

    @Column(name = "coffee_name")
    var coffeeName: String = coffeeName

    // 수량
    @Column(name = "quantity")
    var quantity: Int = quantity

    // 주문 완료
    @Column(name = "order_completed")
    var orderCompleted : Boolean = false
}