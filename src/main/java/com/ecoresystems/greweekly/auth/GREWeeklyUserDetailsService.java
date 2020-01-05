package com.ecoresystems.greweekly.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GREWeeklyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthGroupRepository authGroupRepository;

    public GREWeeklyUserDetailsService (UserRepository userRepository,AuthGroupRepository authGroupRepository){
        super();
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user = this.userRepository.findByMail(mail);
        if (null == user){
            throw new UsernameNotFoundException("Cannot find account associate to this address");
        }
        List<AuthGroup> authGroups = this.authGroupRepository.findByMail(mail);
        return new GREWeeklyUserPrincipal(user,authGroups);
    }
}
