package com.example.aboutcoffee.contoller.api

import com.example.aboutcoffee.dto.UserProfileDTO
import com.example.aboutcoffee.dto.toUserProfile
import com.example.aboutcoffee.service.PresentationService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/profile")
class CoffeeProfileApiController(
    private val presentationService: PresentationService
) {

    @PostMapping("")
    fun createProfile(
        @Valid
        @RequestBody profileInfoDTO : UserProfileDTO
    ) : ResponseEntity<String> {

        if (profileInfoDTO.name.isEmpty()) {
            return ResponseEntity.badRequest().body("name can't be empty")
        }

        if (profileInfoDTO.email.isEmpty()) {
            return ResponseEntity.badRequest().body("email can't be empty")
        }


        val profileList = presentationService.userProfileSearch(profileInfoDTO.name, profileInfoDTO.email)


        return profileList?.let {
            lateinit var responseEntity : ResponseEntity<String>
            if(profileList.isEmpty()) {
                presentationService.profileSave(profileInfoDTO)
                responseEntity =  ResponseEntity.ok().body("profile saved successfully")
            } else {
                responseEntity =  ResponseEntity.ok("이미 사용중인 코드")
            }
            responseEntity
        } ?: kotlin.run {
            ResponseEntity.badRequest().body("저장 실패")
        }
    }
}