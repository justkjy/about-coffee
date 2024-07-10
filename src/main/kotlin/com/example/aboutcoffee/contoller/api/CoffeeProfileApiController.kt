package com.example.aboutcoffee.contoller.api

import com.example.aboutcoffee.domain.entity.CoffeeMenu
import com.example.aboutcoffee.domain.entity.UserProfile
import com.example.aboutcoffee.dto.UserProfileDTO
import com.example.aboutcoffee.service.PresentationService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://client"])
@RestController
@RequestMapping("/api/profile")
class CoffeeProfileApiController(
    private val presentationService: PresentationService
) {

    @PostMapping("")
    fun createProfile(
        @RequestBody profileInfoDTO : UserProfileDTO
    ) : ResponseEntity<String> {

        if (profileInfoDTO.name.isEmpty()) {
            return ResponseEntity.badRequest().body("name can't be empty")
        }

        if (profileInfoDTO.email.isEmpty()) {
            return ResponseEntity.badRequest().body("email can't be empty")
        }

        val profileList = presentationService.userProfileByEmail( profileInfoDTO.email)

        return profileList?.let {
            lateinit var responseEntity : ResponseEntity<String>
            if(profileList.isEmpty()) {
                presentationService.profileSave(profileInfoDTO)
                responseEntity =  ResponseEntity.ok().body("profile saved successfully")
            } else {
                responseEntity =  ResponseEntity.ok("이미 사용중인 email")
            }
            responseEntity
        } ?: kotlin.run {
            ResponseEntity.badRequest().body("저장 실패")
        }
    }

    @RequestMapping(method = [RequestMethod.POST], path=["/PostUserLogin"])
    fun userLogin(
//        @RequestHeader(name = "Content-Type") contentType : String,
        //@RequestBody profileInfoDTO : UserProfileDTO
        @RequestBody name: UserProfileDTO
    ) : String {
        println(name)
        //println(profileInfoDTO)
        //testHtml("/homepage/${name.name}/${name.email}/${name.password}")
        welcome()
        return "OK"
    }

    @GetMapping("welcome")
    fun welcome() = "testpage.html"

    @GetMapping("/homepage/{name}/{email}/{password}")
    fun testHtml(
        @PathVariable email: String,
        @PathVariable password: String,
        @PathVariable name: String

    ) : String {
        println(name)
        //println(profileInfoDTO)
        //println("$profileInfoDTO.email, $profileInfoDTO.password")
        return "hello"
    }

    @GetMapping("/UserLogin/{email}/{password}")
    fun login(
        @PathVariable email: String,
        @PathVariable password: String
    ): ResponseEntity<UserProfile> {
        println("$email, $password")
        return ResponseEntity.ok().body(UserProfile("test", "test", "test", "test"))
    }

    @GetMapping("/delete/{email}")
    fun deleteProfile(@Valid @PathVariable email: String): ResponseEntity<String> {
        if(email.isEmpty()){
            return ResponseEntity.badRequest().body("email can't be empty")
        }

        presentationService.profileDelete(email)

        return when (presentationService.userProfileByEmail(email)?.isEmpty() ?: false)
        {
            true-> ResponseEntity.ok().body("profile deleted successfully")
            else-> ResponseEntity.notFound().build()
        }
    }

    //저장된 포스팅 리스트 ///////////////////////////////////////////////////////////////////
    @GetMapping("/posing/{email}")
    fun getPostCoffeeMenu(
        @PathVariable email: String
    ): ResponseEntity<List<CoffeeMenu>> {
        var coffeeMenuList:List<CoffeeMenu>? = null
        email.isNotEmpty().let {
            presentationService.userProfileByEmail(email)?.let { profile ->
                profile.isNotEmpty().let {
                    val id = profile.first().id
                    coffeeMenuList = presentationService.coffeeMenu().filter { it.userProfileId == id!! }
                }
            }?: kotlin.run {
                ResponseEntity.badRequest()
            }
        }
        return coffeeMenuList?.let {
            ResponseEntity.ok(coffeeMenuList)
        }?: kotlin.run {
            ResponseEntity.badRequest().body(null)
        }
    }


}