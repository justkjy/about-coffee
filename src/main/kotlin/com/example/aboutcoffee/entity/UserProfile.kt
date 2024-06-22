package com.example.aboutcoffee.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class UserProfile(

    name:String = "",

    email:String = "",

    pictureUrl:String = "",

) :BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    var id: Long? = null

    var name: String? = name

    var email: String? = email

    var pictureUrl: String? = pictureUrl
}