package com.example.tlias.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component  // 定义拦截器并将其交给 ioc 容器管理
public class LoginCheckInterceptor implements HandlerInterceptor {
    //目标资源方法运行前运行, 返回true: 放行, 放回false, 不放行
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
//        return HandlerInterceptor.super.preHandle(request, response, handler);
        System.out.println("preHandle");
        // return 的 true 或 false 会影响是否继续运行下去

        // 1.获取请求url
        String url = req.getRequestURL().toString();
        log.info("请求的url: {}", url);
        return true;
    }

    //目标资源方法 运行后 运行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("postHandle");
    }

    //视图渲染完毕后运行, 最后运行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("afterHandle");
    }
}
