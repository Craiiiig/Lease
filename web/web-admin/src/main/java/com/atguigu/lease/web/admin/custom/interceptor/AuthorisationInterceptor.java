package com.atguigu.lease.web.admin.custom.interceptor;

import com.atguigu.lease.common.exception.LeaseException;
import com.atguigu.lease.common.result.ResultCodeEnum;
import com.atguigu.lease.common.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthorisationInterceptor implements HandlerInterceptor {
    // Validate token before calling function

    /**
     * @param request  Get all request information ( Header, payload... )
     * @param response Get all and modify response information
     * @param handler
     * @return Ture: request pass, false otherwise
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Get token from request header.
        String token = request.getHeader("access-token");
        if (token == null) {
            throw new LeaseException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        }
        JwtUtil.parseToken(token);

        return true;
    }
}
