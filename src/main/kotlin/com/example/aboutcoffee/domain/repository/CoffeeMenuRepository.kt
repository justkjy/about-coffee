package com.example.aboutcoffee.domain.repository

import com.example.aboutcoffee.domain.entity.CoffeeMenu
import org.springframework.data.jpa.repository.JpaRepository


interface CoffeeMenuRepository : JpaRepository<CoffeeMenu, Long> {

    // 정보가 없으면 null 아니라 빈값을 전달

    // 등록자별 커피 정보
    fun findByUserProfileId(userId: Long): List<CoffeeMenu>

    // 커피코드별 커피 정보
    fun findAllByCoffeeCodeContainingIgnoreCase(coffeeCode: String): List<CoffeeMenu>

    // 커피 메뉴 삭제
    fun deleteByCoffeeCodeIgnoreCase(coffeeCode: String)
}