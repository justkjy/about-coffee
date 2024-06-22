package com.example.aboutcoffee.repository

import com.example.aboutcoffee.entity.UserProfile
import org.springframework.data.jpa.repository.JpaRepository

interface UserProfileRepository: JpaRepository<UserProfile, Long> {
}