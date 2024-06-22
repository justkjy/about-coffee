package com.example.aboutcoffee.contoller.api.aboutcoffee

import com.example.aboutcoffee.contoller.api.aboutcoffee.model.http.CoffeeMenu
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class AboutCoffeeApiController {

    @GetMapping("/create")
    fun createCoffeeMenu(): String {
        return "create menu"
    }

    @PostMapping("/post-insertMenu")
    fun insertMenu (
        @RequestBody menu:CoffeeMenu
    ) : CoffeeMenu{
        return menu.apply{
            this.coffeeId = 0
        }
    }
}