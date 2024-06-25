package com.example.aboutcoffee.service

import com.example.aboutcoffee.contoller.api.aboutcoffee.model.http.CoffeeMenu
import com.example.aboutcoffee.domain.constant.CoffeeType
import com.example.aboutcoffee.dto.CoffeeMenuDTO
import com.example.aboutcoffee.repository.PresentationRepository
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.MediaType
import org.springframework.test.annotation.Rollback
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(MockitoExtension::class)
class PresentationServiceTest{
    @InjectMocks
    lateinit var presentationService: PresentationService

    @Mock
    lateinit var presentationRepository: PresentationRepository


    @Rollback(false)
    @Test
    fun insertMenuTest() {
        val coffeeMenuDto = CoffeeMenuDTO(
            coffeeCode = "B01",
            category = CoffeeType.NONECOFFEE,
            coffeeName = "고구마라떼",
            coffeeImgUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODA0MThfMjU3%2FMDAxNTI0MDI4MzY2NDA1.XAOdx7bHKnrW-FpBLr_YKn6BVBUoRiMKc4F6RH1rUZUg.9hzS9sZLb7YLIuAu49eJqpHT9p2L8MXOd16fiw17EvUg.JPEG.kaffee_co_kr%2F02.%25B6%25F3%25B6%25BC%2528%25C6%25E4%25C0%25CC%25BD%25BA%25C6%25AE%2529_35.jpg&type=sc960_832",
            coffeeDescription = "노란색 달달한 커피",
            coffeePrice = 2000,
            userProfileId = 0
        )
        val testCoffeeMenu = presentationService.coffeeMenuSave(coffeeMenuDto)
        println(testCoffeeMenu)
    }

}