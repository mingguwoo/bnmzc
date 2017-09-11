package com.woo.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wuminggu on 2017/8/28.
 */
public class PassportInterceptor {
    private final Logger LOGGER = LoggerFactory.getLogger(PassportInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
//        boolean isLogin = false;
        boolean isLogin = true;
        try {
            /*if (this.needParse || this.needLogin(path)) {
                FormsAuthenticationTicket ticket = this.parseDotnetTicket(request, response);
                if (ticket != null && !ticket.isExpired()) {
                    request.setAttribute(JdLoginUtils.PIN, ticket.getUsername());
                    request.setAttribute("pin", ticket.getUsername());
                    isLogin = true;
                }

                if (this.needLogin(path) && !isLogin) {
                    Result result = new Result();
                    result.setCode(ResultCode.NOT_LOGIN.getCode());
                    result.setErrorMsg(ResultCode.NOT_LOGIN.getErrorMsg());
                    result.setSuccess(false);
                    HttpUtils.ajaxResponse(response, result);
                    return false;
                }
            }*/

        } catch (Exception e) {
            LOGGER.error("--parseDotnetTicket error--", e);
            throw new RuntimeException("[passport-check-login error!!!]", e);
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
