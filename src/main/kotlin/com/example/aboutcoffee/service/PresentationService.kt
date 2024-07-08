package com.example.aboutcoffee.service


import com.example.aboutcoffee.domain.entity.CoffeeMenu
import com.example.aboutcoffee.domain.entity.UserProfile
import com.example.aboutcoffee.domain.repository.CoffeeMenuRepository
import com.example.aboutcoffee.domain.repository.CoffeeOrderRepository
import com.example.aboutcoffee.domain.repository.UserProfileRepository
import com.example.aboutcoffee.dto.CoffeeMenuDTO
import com.example.aboutcoffee.dto.UserProfileDTO
import com.example.aboutcoffee.dto.toCoffeeMenu
import com.example.aboutcoffee.dto.toUserProfile
import com.example.aboutcoffee.repository.PresentationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class PresentationService(
private val presentationRepository: PresentationRepository) {


    @Transactional
    fun coffeeMenuSave(menuDTO: CoffeeMenuDTO):CoffeeMenu? {
        val menu = menuDTO.toCoffeeMenu()

        return presentationRepository.getCoffeeMenuByCoffeeCode(menu.coffeeCode)?.run {
            var resultMenu : CoffeeMenu?
            if(this.isNotEmpty())
                resultMenu = presentationRepository.coffeeMenuUpdate(menu)
            else {
                val menuSave = CoffeeMenu().apply {
                    //this.id = null
                    this.coffeeCode = menu.coffeeCode
                    this.category = menu.category
                    this.coffeeName = menu.coffeeName
                    this.coffeeDescription = menu.coffeeDescription
                    this.coffeePrice = menu.coffeePrice
                    this.coffeeImgUrl = menu.coffeeImgUrl
                    this.userProfileId = menu.userProfileId
                }
                //////////////////////////////////////////////////////////////////
                // 여기 ///////////////////////////////////////////////////////////
                ///////////////////////////////////////////////////////////////////
                // 왜 저장이 되지 않는지 모르겠음 //////////////////////////////////////
                //////////////////////////////////////////////////////////////////
                resultMenu = presentationRepository.coffeeMenuSave(menuSave)
                val menuAll = presentationRepository.getCoffeeMenu()
                println(menuAll)
            }
            resultMenu
        }?: kotlin.run {
            null
        }

    }

    fun coffeeMenuSearch(coffeeCode: String): List<CoffeeMenu>? {
        return presentationRepository.getCoffeeMenuByCoffeeCode(coffeeCode)
    }

    fun coffeeMenu() : List<CoffeeMenu> {
        return presentationRepository.getCoffeeMenu()
    }

    @Transactional
    fun coffeeMenuDelete(coffeeCode: String)  {
        presentationRepository.coffeeMenuDelete(coffeeCode)
    }

    @Transactional
    fun profileSave(userProfileDTO: UserProfileDTO): UserProfile? {
        val userProfile = userProfileDTO.toUserProfile()
        return userProfile.id?.let {
            UserProfile()
        } ?: kotlin.run {
            presentationRepository.userProfileSave(userProfile)
        }
    }

    fun userProfileSearch(name: String, email: String): List<UserProfile>? {
        return presentationRepository.getUserProfileIdByNameAndEmail(name, email)
    }

    fun userProfileByEmail(email: String): List<UserProfile>? {
        return presentationRepository.getUserProfileInfoByEmail(email)
    }

    @Transactional
    fun profileDelete(email: String) {
        presentationRepository.userProfileDelete(email)
    }
}