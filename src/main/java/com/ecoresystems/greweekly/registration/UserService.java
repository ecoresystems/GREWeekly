package com.ecoresystems.greweekly.registration;

import com.ecoresystems.greweekly.data.entity.Users;
import com.ecoresystems.greweekly.data.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    @Override
    public Users registerNewUserAccount(UserModel userModel) throws EmailExistsException
}
