package com.example.aboutcoffee

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import com.example.aboutcoffee.contoller.api.aboutcoffee.model.http.CoffeeMenu
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

//@WebMvcTest
//@AutoConfigureMockMvc
@SpringBootTest
class AboutCoffeeApplicationTests {

//    @Autowired
//    private lateinit var validationAutoConfiguration: ValidationAutoConfiguration
//
//    @Autowired
//    lateinit var mockMvc: MockMvc
//
//    @Test
//    fun insertMenuTest(){
//        val menuRequest = CoffeeMenu().apply{
//            this.coffeeId = 0
//            this.coffeeName = "아메리카노"
//            this.description = "기본 커피"
//            this.price = 2000
//            this.imageUrl = "---"
//        }
//        val json = jacksonObjectMapper().writeValueAsString(menuRequest)
//
//        mockMvc.perform(
//            post("/api/post-insertMenu")
//                .content(json)
//                .contentType("application/json")
//                .accept(MediaType.APPLICATION_JSON)
//        ).andExpect(
//            status().isOk
//        ).andExpect(
//            jsonPath("$.coffeeName").value("아메리카노")
//        ).andDo(print())
//    }

//    @Test
//    fun test() {
//        val encrypted = BCryptPasswordEncoder().encode("123456")
//        println(encrypted)
//    }

    //@Test
    //fun jasypt() {
    //    val plainText = "1234"

//        val encryptor = PooledPBEStringEncryptor()
//        val config = SimpleStringPBEConfig()
//        config.password = "q1w2e3"
//        config.algorithm = "PBEWithMD5AndDES"
//        config.setKeyObtentionIterations("1000")
//        config.setPoolSize("1")
//        config.providerName = "SunJCE"
//        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator")
//        config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator")
//        config.stringOutputType = "base64"
//        encryptor.setConfig(config)
//
//        val encryptedText: String = encryptor.encrypt(plainText)
//        val decryptedText: String = encryptor.decrypt(encryptedText)
//
//        println(encryptedText)
//        println(decryptedText)
    //}

}
