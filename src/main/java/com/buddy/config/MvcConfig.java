package com.buddy.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

import java.io.File;
import java.util.Locale;

@Configuration
public class MvcConfig implements WebMvcConfigurer
{
    //    @Bean
    //    public AuthenticationProvider authProvider(){
    //
    //    }

    @Override
    public void addViewControllers( ViewControllerRegistry registry )
    {
        registry.addViewController( "/test" ).setViewName( "test" );
        registry.addViewController( "/login" ).setViewName( "login" );
        registry.addViewController( "/logout" ).setViewName( "login" );
        registry.addViewController( "/accessDenied" ).setViewName( "access_Deny" );
    }

    @Bean
    public LocaleResolver localeResolver()
    {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale( Locale.US );
        return sessionLocaleResolver;
    }
    /*
       The LocaleResolver interface has implementations that determine the current locale based on the session, cookies, the Accept-Language header, or a fixed value.
       In our example, we have used the session based resolver SessionLocaleResolver and set a default locale with value US.
    */

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor()
    {
        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        localeInterceptor.setParamName( "lang" );
        return localeInterceptor;
    }
     /*
        Next, we need to add an interceptor bean that will switch to a new locale based on the value of the lang parameter appended to a request:
     */

    @Bean(name = "messageSource") public MessageSource messageSource()
    {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames( "classpath:/i18n/messages" );
        messageSource.setDefaultEncoding( "UTF-8" );
        return messageSource;
    }

    @Bean
    public ResourceBundleThemeSource themeSource()
    {
        ResourceBundleThemeSource themeSource = new ResourceBundleThemeSource();
        themeSource.setBasenamePrefix( "theme-" );
        return themeSource;
    }

    @Bean
    public CookieThemeResolver themeResolver()
    {
        CookieThemeResolver themeResolver = new CookieThemeResolver();
        themeResolver.setDefaultThemeName( "ONE" );
        themeResolver.setCookieName( "my-theme-cookie" );
        return themeResolver;
    }

    @Bean
    public ThemeChangeInterceptor themeChangeInterceptor()
    {
        ThemeChangeInterceptor interceptor = new ThemeChangeInterceptor();
        interceptor.setParamName( "brand" );
        return interceptor;
    }

    @Override
    public void addInterceptors( InterceptorRegistry registry )
    {
        registry.addInterceptor( localeChangeInterceptor() );
        registry.addInterceptor( themeChangeInterceptor() );
    }
}
