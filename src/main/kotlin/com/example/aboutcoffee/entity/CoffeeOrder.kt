package com.example.aboutcoffee.entity

import jakarta.persistence.*

@Entity
class CoffeeOrder : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    var id: Long? = null
}