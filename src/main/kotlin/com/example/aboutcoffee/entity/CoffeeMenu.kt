package com.example.aboutcoffee.entity

import jakarta.persistence.*

@Entity
class CoffeeMenu : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    var id: Long? = null
}