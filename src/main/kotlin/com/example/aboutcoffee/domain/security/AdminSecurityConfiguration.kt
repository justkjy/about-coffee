package com.example.aboutcoffee.domain.security


//@Configuration
//@EnableWebSecurity
//class AdminSecurityConfiguration {
//
//    @Bean
//    fun passwordEncoder(): PasswordEncoder {
//        return BCryptPasswordEncoder()
//    }
//
///*    @Bean
//    fun webSecurityCustomizers() : WebSecurityCustomizer {
//        return WebSecurityCustomizer {
//            override fun customize(web: WebSecurity) {
//                web.ignoring()
//                    .requestMatchers("/favicon.ico")
//                    .requestMatchers("/error")
//                    .requestMatchers(toH2Console())
//            }
//        }
//    }*/
//
//    @Bean
//    fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
//        return httpSecurity
//            .authorizeHttpRequests { authorizeHttpRequests ->
//                authorizeHttpRequests
//                    .requestMatchers(AntPathRequestMatcher("/admin/**")).authenticated()
//                    .anyRequest().permitAll()
//            }.csrf {csrf ->
//                csrf.disable()
//            }.headers { headers ->
//                headers.addHeaderWriter(XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
//            }.formLogin { formLogin ->
//                formLogin.defaultSuccessUrl("/admin")
//            }.logout { logout->
//                logout.logoutRequestMatcher(AntPathRequestMatcher("/admin/logout"))
//                    .logoutSuccessUrl("/")
//            }.build()
//    }
//}