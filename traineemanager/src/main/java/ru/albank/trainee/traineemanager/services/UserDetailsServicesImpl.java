package ru.albank.trainee.traineemanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.albank.trainee.traineemanager.models.User;
import ru.albank.trainee.traineemanager.repo.UserRepo;

@Service
public class UserDetailsServicesImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with username: " + username ));
        return UserDetailsImpl.build(user);
    }
}
