package com.example.aboutcoffee.repository

import com.example.aboutcoffee.domain.entity.CoffeeMenu
import com.example.aboutcoffee.domain.entity.UserProfile
import com.example.aboutcoffee.domain.repository.CoffeeMenuRepository
import com.example.aboutcoffee.domain.repository.CoffeeOrderRepository
import com.example.aboutcoffee.domain.repository.UserProfileRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Component
@Repository
class PresentationRepository(
    private val userProfileRepository: UserProfileRepository,
    private val coffeeMenuRepository: CoffeeMenuRepository,
    private val userOrderRepository: CoffeeOrderRepository,
) {

    // CoffeeMenuRepository ///////////////////////////////
    // 케피 정보 모두 제출
    fun getCoffeeMenu() : List<CoffeeMenu> {
        return coffeeMenuRepository.findAll()
    }

    // 작성자 커피 정보 제출
    fun getCoffeeMenuByProfileIdOrProfileInf(
        profileId : Long? = null,
        profileName: String? = null,
        profileEmail: String? = null
    ) : List<CoffeeMenu>? {
        return profileId?.let {
            val isId = getIsUseById(profileId)
            var menu : List<CoffeeMenu>? = null
            if( isId) {
                menu = coffeeMenuRepository.findByUserProfileId(profileId)
            }
            menu
        } ?: kotlin.run {
            var menu : List<CoffeeMenu>? = null
            profileName?.let{
                profileEmail?.let{
                    val id = getUserProfileIdByNameAndEmail(profileName, profileEmail)
                    id?.let {
                        menu = coffeeMenuRepository.findByUserProfileId(id)
                    }
                }
            }
            menu
        }
    }

    // 커피 코드로 커피 정보 제출
    fun getCoffeeMenuByCoffeeCode(coffeeCode: String) : List<CoffeeMenu>? {
        val coffeeMenu = coffeeMenuRepository.findByCoffeeCode(coffeeCode)
        return coffeeMenu
    }

    // 커피 정보 저장
    fun coffeeMenuSave(menu: CoffeeMenu): CoffeeMenu {
        return coffeeMenuRepository.save(menu)
    }

    fun coffeeMenuUpdate(coffeeMenu: CoffeeMenu): CoffeeMenu? {
        return coffeeMenu.id?.let {

            coffeeMenuRepository.save(coffeeMenu)

        } ?: kotlin.run {
            null
        }

    }
    // UserProfileRepository ///////////////////////////////////////////////////////////
    // 등록자 모든 정보 획득
    fun getAllProfile() : MutableList<UserProfile> {
        return userProfileRepository.findAll()
    }

    // 등록자 정보 Id by name, email
    fun getUserProfileIdByNameAndEmail(
        name : String,
        email : String
    ): Long? {
        val id = userProfileRepository.findByNameIgnoreCaseAndEmailIgnoreCase(name, email).first().id ?: return null

        return id
    }

    // 등록자 정보 id 존재 여부 확인
    fun getIsUseById(id: Long) : Boolean {
        userProfileRepository.findAllById(id).first().id?: return false
        return true
    }
}