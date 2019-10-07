package com.buddy.config;

import com.buddy.interceptors.DataInterceptor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    @Bean
    public RestTemplate getRestTemplate()
    {
        RestTemplate restTemplate = new RestTemplate();


        /*  The main problem here is content type [text/html;charset=iso-8859-1] received from the service, however the real content type should be application/json;charset=iso-8859-1
        In order to overcome this you can introduce custom message converter. and register it for all kind of responses (i.e. ignore the response content type header). Just like this   */

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        // Note: here we are making this converter to process any kind of response,
        // not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes( Collections.singletonList( MediaType.ALL ) );
        messageConverters.add( converter );
        restTemplate.setMessageConverters( messageConverters );

        return restTemplate;
    }

    @Bean public DataInterceptor dataInterceptor()
    {
        DataInterceptor di = new DataInterceptor();
        return di;
    }

    @Override
    public void addInterceptors( InterceptorRegistry registry )
    {
        registry.addInterceptor( localeChangeInterceptor() );
        registry.addInterceptor( themeChangeInterceptor() );
        registry.addInterceptor( dataInterceptor() );
    }
}
