package com.louis.EazySchool.secuirty;

import com.louis.EazySchool.Repository.PersonRepository;
import com.louis.EazySchool.model.Person;
import com.louis.EazySchool.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// Authenticate the password for login
@Component
public class EazySchoolUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        Person person = personRepository.readByEmail(email);
        if(null != person && person.getPersonId()>0 && passwordEncoder.matches(password, person.getPwd())){
            return new UsernamePasswordAuthenticationToken(email, null, getGrantedAuthorities(person.getRole()));
        }else{
            throw new BadCredentialsException("Invalid credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


    // support multiple roles as well
    private List<GrantedAuthority> getGrantedAuthorities(Roles role) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        return grantedAuthorities;
    }
}
