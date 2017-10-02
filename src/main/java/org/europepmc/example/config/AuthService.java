package org.europepmc.example.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("authService")
@PropertySource("classpath:/app.properties")
public class AuthService implements UserDetailsService {

    @Value("${username_digest}")
    private String apertaUsername;

    @Value("${password_digest}")
    private String apertaPassword;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (apertaUsername.equals(username)) {
            ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            UserDetails user = new User(apertaUsername, apertaPassword, true, true, true, true, grantedAuthorities);
            return user;
        }

        return null;
    }

}
