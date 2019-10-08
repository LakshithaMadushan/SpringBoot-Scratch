package com.buddy.config;

import com.buddy.constants.PermissionConstants;
import com.buddy.util.CustomAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure( HttpSecurity http ) throws Exception
    {
        // http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();    // we're allowing unrestricted access to all endpoints.

        http.authorizeRequests()
                .antMatchers( "/test", "/international", "/css/**", "/employees/**", "/build-info", "/YAML-Props" ).permitAll()
                .antMatchers( "/members/dog" ).hasRole( "DOG" )
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage( "/login" )
                .permitAll()
                .and()
                .logout().invalidateHttpSession( true )
                .clearAuthentication( true )
                .logoutRequestMatcher( new AntPathRequestMatcher( "/logout" ) )
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler( accessDeniedHandler() );
        //                .exceptionHandling().accessDeniedPage( "/accessDenied" );
    }

    //    @Bean
    //    @Override
    //    public UserDetailsService userDetailsService()
    //    {
    //        List<UserDetails> users = new ArrayList<>();
    //        users.add( Employee.withDefaultPasswordEncoder()
    //                .username( "buddy" )
    //                .password( "buddy@1234" )
    //                .roles( "USER" )
    //                .build() );
    //
    //        users.add( Employee.withDefaultPasswordEncoder()
    //                .username( "geethi" )
    //                .password( "geethi@1234" )
    //                .roles( "ADMIN" )
    //                .build() );
    //
    //        return new InMemoryUserDetailsManager( users );
    //    }

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception
    {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser( "binki" ).password( encoder.encode( "binki@1234" ) ).roles( PermissionConstants.DOG_ROLE )
                .and()
                .withUser( "any" ).password( encoder.encode( "any@1234" ) ).roles( PermissionConstants.USER_ROLE, PermissionConstants.ADMIN_ROLE )
                .and()
                .withUser( "geethi" ).password( encoder.encode( "geethi@1234" ) ).roles( PermissionConstants.ADMIN_ROLE );
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler()
    {
        return new CustomAccessDeniedHandler();
    }
}
