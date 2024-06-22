package com.example.aboutcoffee.repository

import com.example.aboutcoffee.entity.CoffeeOrder
import org.springframework.data.jpa.repository.JpaRepository

interface CoffeeOrderRepository: JpaRepository<CoffeeOrder, Long> {
}