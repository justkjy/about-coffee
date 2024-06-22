package com.example.aboutcoffee.domain.repository

import com.example.aboutcoffee.domain.entity.CoffeeOrder
import org.springframework.data.jpa.repository.JpaRepository

interface CoffeeOrderRepository: JpaRepository<CoffeeOrder, Long> {
}