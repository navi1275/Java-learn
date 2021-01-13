package com.navi.config;

import cn.hutool.core.util.StrUtil;
import com.navi.dto.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * NaviExceptionHandler Class
 *
 * @author ganxf
 * @date 2020/7/2
 */
@RestControllerAdvice
public class NaviExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object defaultErrorHandler(HttpServletRequest request, Exception ex) throws Exception {
        String servletPath = request.getServletPath();
        String xhr = request.getHeader("X-Requested-With");
        if(servletPath.startsWith("/app") || StrUtil.equals(xhr, "XMLHttpRequest")) {
            return CommonResult.builder().status("0").errorMsg(ex.getMessage()).build();
        }else{
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", ex);
            mav.addObject("url", request.getRequestURL());
            mav.setViewName("error/500");
            return mav;
        }

    }

}
