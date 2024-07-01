package com.example.tlias.filter;

import com.example.tlias.pojo.Result;
import com.example.tlias.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.bootstrap.HttpServer;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    //  客户端发起的请求对象, 服务器发送给客户端的响应对象, 过滤器链对象，用于调用下一个过滤器或处理器处理请求
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 1.获取请求url
        String url = req.getRequestURL().toString();
        log.info("清华求的 url: {}", url);

        // 2.判断请求url中是否包含login，如果包含，说明是登录操作，放行
        if(url.contains("login")) {
            log.info("登录操作，放行...");
            chain.doFilter(request, response);
            return;
        }

        // 3. 获取请求头中的令牌
        String jwt = req.getHeader("token");    // 从HTTP请求的头部获取名为"token"的值，这是客户端发送的JWT

        // 4. 判断令牌是否存在，若不存在，返回错误结果().
        if (!StringUtils.hasLength(jwt)){   // 使用Spring框架的工具类StringUtils判断jwt是否为null或空字符串
            log.info("请求头token为空，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象--json --------> 阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);   // 将错误结果对象转换为JSON格式的字符串
            resp.getWriter().write(notLogin);   //  将JSON字符串作为响应内容写入到HTTP响应中，并结束请求处理
            return;
        }

        // 5.解析token，如果解析失败，返回错误结果（未登录）
        try {
            JwtUtils.parseJWT(jwt); // 调用JwtUtils类的parseJWT方法,解析JWT
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象--json --------> 阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        //6.放行。
        log.info("令牌合法, 放行");
        chain.doFilter(request, response);
    }
}
