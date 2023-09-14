package com.lin.common.utils;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author lin
 */
public class HttpContextUtils {

    public static HttpServletRequest getHttpServletRequest() {
//        ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

}
