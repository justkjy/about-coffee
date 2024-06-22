package com.example.aboutcoffee

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import com.example.aboutcoffee.contoller.api.aboutcoffee.model.http.CoffeeMenu
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

@WebMvcTest
@AutoConfigureMockMvc
class AboutCoffeeApplicationTests {

    @Autowired
    private lateinit var validationAutoConfiguration: ValidationAutoConfiguration

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun insertMenuTest(){
        val menuRequest = CoffeeMenu().apply{
            this.coffeeId = 0
            this.coffeeName = "아메리카노"
            this.description = "기본 커피"
            this.price = 2000
            this.imageUrl = "---"
        }
        val json = jacksonObjectMapper().writeValueAsString(menuRequest)

        mockMvc.perform(
            post("/api/post-insertMenu")
                .content(json)
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(
            status().isOk
        ).andExpect(
            jsonPath("$.coffeeName").value("아메리카노")
        ).andDo(print())
    }

}
