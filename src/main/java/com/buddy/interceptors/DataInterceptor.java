package com.buddy.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataInterceptor extends HandlerInterceptorAdapter
{
    private static Logger log = LoggerFactory.getLogger( DataInterceptor.class );

    @Override
    public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception
    {
        log.info( "Buddy Http Interceptor" + request.getRequestURI() );

        return true;
    }
}
