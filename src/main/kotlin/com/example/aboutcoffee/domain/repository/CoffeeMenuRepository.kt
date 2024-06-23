package com.example.aboutcoffee.domain.repository

import com.example.aboutcoffee.domain.entity.CoffeeMenu
import org.springframework.data.jpa.repository.JpaRepository


interface CoffeeMenuRepository : JpaRepository<CoffeeMenu, Long> {

    fun findByUserProfileId(userId: Long): List<CoffeeMenu>

}