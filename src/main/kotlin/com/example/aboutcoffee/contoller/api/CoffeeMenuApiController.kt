package com.example.aboutcoffee.contoller.api

import com.example.aboutcoffee.domain.entity.CoffeeMenu
import com.example.aboutcoffee.dto.CoffeeMenuDTO
import com.example.aboutcoffee.service.PresentationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/coffee")
class CoffeeMenuApiController(
    private val presentationService: PresentationService
) {
    @PostMapping("")
    fun createMenu(@RequestBody menuDto: CoffeeMenuDTO) :String {
        val isNewMenu = presentationService.coffeeMenuSearch(menuDto.coffeeCode)?.isEmpty() ?: false
        return if(isNewMenu) {
            menuDto.apply {
                this.coffeeCode = this.coffeeCode.uppercase()
            }
            presentationService.coffeeMenuSave(menuDto)?.run {
                "저장 완료"
            } ?: "저장 실패"
        } else {
            "이미 사용중인 코드"  // 이미등록된 코드
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
        @PathVariable (value="coffee_code") coffeeCode: String
    ) : Boolean {

        presentationService.coffeeMenuDelete(coffeeCode.uppercase())
        return presentationService.coffeeMenuSearch(coffeeCode)?.isEmpty() ?: false
    }


}