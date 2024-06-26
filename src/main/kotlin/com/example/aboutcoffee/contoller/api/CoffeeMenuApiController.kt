package com.example.aboutcoffee.contoller.api

import com.example.aboutcoffee.domain.entity.CoffeeMenu
import com.example.aboutcoffee.dto.CoffeeMenuDTO
import com.example.aboutcoffee.service.PresentationService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/coffee")
class CoffeeMenuApiController(
    private val presentationService: PresentationService
) {
    @PostMapping("")
    fun createMenu(
        @Valid
        @RequestBody menuDto: CoffeeMenuDTO
    ) : ResponseEntity<String> {
        if(menuDto.coffeeCode.isEmpty())
            return ResponseEntity.badRequest().body("Coffee Menu can't be empty")
        val isNewMenu = presentationService.coffeeMenuSearch(menuDto.coffeeCode)?.isEmpty() ?: false
        return if(isNewMenu) {
            menuDto.apply {
                this.coffeeCode = this.coffeeCode.uppercase()
            }
            presentationService.coffeeMenuSave(menuDto)?.run {
                ResponseEntity.ok("저장완료")
            } ?: ResponseEntity.status(500).body("저장 실패")
        } else {
            ResponseEntity.ok("이미 사용중인 코드")
        }
    }

    @GetMapping("/coffeeMenu/{coffee_code}")
    fun getCoffeeMenu(
        @PathVariable (value="coffee_code") coffeeCode: String
    ):List<CoffeeMenu>? {
        return when(coffeeCode.uppercase()) {
            "ALL" -> presentationService.coffeeMenu()
            else -> presentationService.coffeeMenuSearch(coffeeCode)
        }
    }

    @DeleteMapping("delete/{coffee_code}")
    fun deleteCoffeeMenu(
        @Valid
        @PathVariable (value="coffee_code") coffeeCode: String
    ) : Any? {
        return try {
            when (presentationService.coffeeMenuSearch(coffeeCode)?.isNotEmpty() ?: false) {
                true -> {
                    presentationService.coffeeMenuDelete(coffeeCode)
                    ResponseEntity.ok("삭제 완료")
                }

                else -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("${coffeeCode}가 없습니다.")
            }
        } catch (e: Exception) {
            ResponseEntity.badRequest().body("요청이 잘못되었습니다.")
        }
    }
}