package org.europepmc.example.config;

import org.springframework.security.web.context.*;

/**
 * 
 * https://docs.spring.io/spring-security/site/docs/current/apidocs/org/springframework/security/web/context/AbstractSecurityWebApplicationInitializer.html
 * 
 * @author ygou
 *
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer() {
        super(SecurityConfig.class);
    }

}