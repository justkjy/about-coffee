package com.example.aboutcoffee.domain.entity

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

    password:String = ""

) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    var id: Int? = null

    var name: String = name

    @Column(unique = true)
    var email: String = email

    @Column(name = "picture_url", length = 500)
    var pictureUrl: String? = pictureUrl

    @Column(name = "password")
    var password: String = password

}