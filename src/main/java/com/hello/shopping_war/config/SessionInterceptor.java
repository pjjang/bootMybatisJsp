package com.hello.shopping_war.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class SessionInterceptor implements HandlerInterceptor {

//    private static final List<String> EXCLUDE_PATHS = Arrays.asList("/", "/product/list", "/shopping");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();



        // 제외할 경로인지 확인
//        if (EXCLUDE_PATHS.contains(requestURI)) {
//            log.info("Exclude path: {}", requestURI);
//            return true;
//        }

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("loginMember") == null) {

            // AJAX 요청인 경우
            if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("{\"sessionExpired\": true}");
            } else {
                // 일반 요청인 경우
                response.sendRedirect("/member/login?sessionExpired=true");
            }
            return false;
        }
        return true;
    }
}