package com.example.aboutcoffee.domain.repository

import com.example.aboutcoffee.domain.entity.UserProfile
import org.springframework.data.jpa.repository.JpaRepository

interface UserProfileRepository: JpaRepository<UserProfile, Long> {
    fun findByNameLikeIgnoreCase(name: String): List<UserProfile>

    fun findByNameIgnoreCaseAndEmailIgnoreCase(name: String, email:String): List<UserProfile>

    fun findAllById(id : Long): List<UserProfile>
}