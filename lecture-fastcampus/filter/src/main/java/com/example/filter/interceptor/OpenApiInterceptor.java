package com.example.filter.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OpenApiInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // controller 전달 true, false;
        log.info("pre handle");

        var handlerMethod = (HandlerMethod) handler;
        var methodLevel = handlerMethod.getMethodAnnotation(OpenApi.class);
        if (methodLevel != null) return true;

        var classLevel = handlerMethod.getBeanType().getAnnotation(OpenApi.class);
        if (classLevel != null) return true;
        
        log.info("open api 아닙니다 : {}", request.getRequestURI());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        
        log.info("post handle");

        // HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        
        log.info("after completion");

        // HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
