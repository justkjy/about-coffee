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

    // 작성자 커피 정보 제출
    // 커피 검색시에 이름과 이메일로 검색하려면 profileId는 null, profileId로 조회 하려면 profileId에 값을 등록
    fun getCoffeeMenuByProfileIdOrProfileInfo(
        profileId : Long? = null,
        profileName: String? = null,
        profileEmail: String? = null
    ) : List<CoffeeMenu>? {
        // 커피 코드로 검색
        return profileId?.let {
            var menu : List<CoffeeMenu>? = null
            if( getIsUseById(profileId)) {
                menu = coffeeMenuRepository.findByUserProfileId(profileId)
            }
            menu
        } ?: kotlin.run { // 커피 이름과 이메일로 검색
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

    // 케피 정보 모두 제출
    fun getCoffeeMenu() : List<CoffeeMenu> {
        return coffeeMenuRepository.findAll()
    }

    // 커피 코드로 커피 정보 제출
    fun getCoffeeMenuByCoffeeCode(coffeeCode: String) : List<CoffeeMenu>? {
        val coffeeMenu = coffeeMenuRepository.findAllByCoffeeCodeContainingIgnoreCase(coffeeCode)
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

    fun coffeeMenuDelete(coffeeCode: String) {
        return coffeeMenuRepository.deleteByCoffeeCodeIgnoreCase(coffeeCode)
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