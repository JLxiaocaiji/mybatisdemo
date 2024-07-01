package com.example.tlias.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.tlias.pojo.Result;
import com.example.tlias.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component  // 定义拦截器并将其交给 ioc 容器管理
public class LoginCheckInterceptor implements HandlerInterceptor {
    //目标资源方法运行前运行, 返回true: 放行, 放回false, 不放行， 在此之陷阱拦截操作
    @Override
    // 客户端发起的HTTP请求对象, 服务器向客户端发送的HTTP响应对象, 代表请求的处理器（handler）
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
//        return HandlerInterceptor.super.preHandle(request, response, handler);
        System.out.println("preHandle");
        // return 的 true 或 false 会影响是否继续运行下去

        // 1.获取请求url
        String url = req.getRequestURL().toString();
        log.info("请求的url: {}", url);

        //2.判断请求url中是否包含login，如果包含，说明是登录操作，放行。
        if ( url.contains("login")) {
            log.info("登录操作, 放行...");
            return true;
        }

        // 3.获取请求头中的令牌（token）
        String jwt = req.getHeader("token");


        // 4.判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if(!StringUtils.hasLength(jwt)) {
            log.info("请求头token为空,返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        //5.解析token，如果解析失败，返回错误结果（未登录）
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败, 返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象--json --------> 阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        //6.放行。
        log.info("令牌合法, 放行");
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
