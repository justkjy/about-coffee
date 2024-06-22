package com.example.aboutcoffee.domain

import com.example.aboutcoffee.domain.constant.CoffeeType
import com.example.aboutcoffee.domain.entity.CoffeeMenu
import com.example.aboutcoffee.domain.repository.CoffeeMenuRepository
import com.example.aboutcoffee.domain.repository.CoffeeOrderRepository
import com.example.aboutcoffee.domain.repository.UserProfileRepository
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component


@Component
@Profile(value=["default"])
class DataInitializer(
    private val coffeeMenuRepository: CoffeeMenuRepository,
    private val coffeeOrderRepository: CoffeeOrderRepository,
    private val userProfileRepository: UserProfileRepository
) {
    @PostConstruct
    fun initializeData() {
        // 아래 문 사용하면 느려짐
        println("스프링이 실행되었습니다. 테스트 데이터를 초기화 합니다. ")

        val coffeeMenus = mutableListOf(
            CoffeeMenu(
                coffeeCode = 0,
                coffeeName = "아메리카노",
                coffeeImgUrl = "https://postfiles.pstatic.net/MjAyNDA0MTVfNTIg/MDAxNzEzMTM5NTAzNzc2.3zol_RfLTo358KTCm4EXfgKnu9OTeyOzamgJMwp9ligg.7gjTpr_A-Fg7OzDtjZ2PLD8ngEa1Qo0jKlHpjkwfKk4g.PNG/20240414_143912_1.png?type=w773",
                coffeeDescription = "에스프레소에 물을 넣어 연하게 마시는 커피이다. 적당량의 뜨거운 물을 섞는 방식이 연한 커피를 즐기는 미국에서 시작된 것이라 하여 ‘아메리카노’라 부른다. 우리나라에서도 가장 인기 있는 메뉴 중 하나이다.\n" +
                        "\n" +
                        "에스프레소에 쓰이는 원두와 물의 양에 따라 커피 맛이 천차만별이다. 참고로 물을 넣어 희석시켰다고 해서 커피 맛도 흐려지는 것은 아니다. 오히려 뜨거운 물이 맛을 더욱 부드럽게 살려 주어 커피 본연의 특징을 강조해 주기도 한다. 머그잔에 적당량의 물을 붓고 난 후 살살 돌리면서 에스프레소를 부어주면 진한 크레마가 살짝 떠서 더 맛있어 보인다.\n"+
                        "[네이버 지식백과] 아메리카노 [Americano] (내 입맛에 딱 맞는 60가지 커피 수첩, 2011. 10. 15., 김은지)",
                coffeePrice = 2000,
                userProfileId = 0
            ),

            CoffeeMenu(
                coffeeCode = 1,
                coffeeName = "에스프레소",
                coffeeImgUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyNDA1MjNfMjc1%2FMDAxNzE2NDUxMDcxNzk4.klQRE6A_p_QA2Hj8mtMXN9b0gFqMGSvRXnqxbz0o6TAg.YxSpagNKyuibgKzIF1CyPqNuWE98tfOsz6L7RK6himkg.JPEG%2FIMG_8841.jpeg&type=sc960_832",
                coffeeDescription = "아주 진한 이탈리아식 커피이다. 데미타세(demitasse)라는 조그만 잔에 담아서 마셔야 제맛을 느낄 수 있다. 높은 압력으로 짧은 순간에 커피를 추출하기 때문에 카페인의 양이 적고, 커피의 순수한 맛을 느낄 수 있다. 에스프레소(Espresso)의 영어식 표기인 '익스프레스(express)'는 '빠르다'라는 의미로 사용된다.",
                coffeePrice = 1800,
                userProfileId = 0
            ),

            CoffeeMenu(
                coffeeCode = 2,
                coffeeName = "케라라떼",
                coffeeImgUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzA4MTZfMjUw%2FMDAxNjkyMTE0OTc0MDIw.2Hue6mPJLXslBQsawOg7zU2FU7U_OVUxwLQQ0QnnXBYg.UnMA23LWfASbn25jguz45_5ZfL2qxr6zkiSRbyVTgH4g.PNG.estroad%2F%25C4%25AB%25C6%25E4%25B6%25F3%25B6%25BC%25BF%25CF%25BC%25BA.png&type=sc960_832",
                coffeeDescription = "우유를 이용한 대표적인 커피로, 라테는 이탈리아어로 ‘우유’를 뜻한다. 우유를 따뜻하게 데워서 에스프레소와 우유의 비율을 1:4 정도로 섞어 마신다. 부드러운 우유 맛이 일품인 라테는 양을 많이 해서 큰 잔에 마시는 것이 특징이다. 아침 식사로 빵과 곁들여도 좋고, 이것만 마셔도 식사 대용으로 든든하다.\n" +
                        "\n" +
                        "라테를 만들 때에는 마무리로 우유 거품을 살짝 얹는 것이 좋다. 거품이 뚜껑 역할을 해서 온도가 떨어지는 것을 막아주기 때문이다. 하지만 자칫 거품이 두껍게 올라가면 카푸치노처럼 보일 수 있으니 얇은 뚜껑을 덮어 준다는 기분으로 살짝 얹으면 된다.",
                coffeePrice = 3000,
                userProfileId = 0
            )
        )

        coffeeMenuRepository.saveAll(coffeeMenus)
    }
}
