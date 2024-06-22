package com.example.aboutcoffee.repository

import com.example.aboutcoffee.entity.CoffeeMenu
import org.springframework.data.jpa.repository.JpaRepository

interface CoffeeMenuRepository : JpaRepository<CoffeeMenu, Long> {

}