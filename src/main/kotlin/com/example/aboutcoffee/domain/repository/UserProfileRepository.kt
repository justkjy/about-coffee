package com.example.aboutcoffee.domain.repository

import com.example.aboutcoffee.domain.entity.UserProfile
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface UserProfileRepository: JpaRepository<UserProfile, Long> {
    fun findByNameLikeIgnoreCase(name: String): List<UserProfile>

    fun findByNameIgnoreCaseAndEmailIgnoreCase(name: String, email:String): List<UserProfile>

    fun findByEmailIgnoreCase(email: String): List<UserProfile>

    fun findAllById(id : Int): List<UserProfile>

    fun deleteUserByEmailIgnoreCase(email: String)

}