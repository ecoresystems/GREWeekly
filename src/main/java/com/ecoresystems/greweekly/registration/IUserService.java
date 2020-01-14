package com.ecoresystems.greweekly.registration;

import com.ecoresystems.greweekly.data.entity.Users;

public interface IUserService {
    Users registerNewUserAccount(UserModel userModel) throws EmailExistsException;
}
