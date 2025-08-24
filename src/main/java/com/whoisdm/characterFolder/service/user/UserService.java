package com.whoisdm.characterFolder.service.user;

import com.whoisdm.characterFolder.model.user.RegistrationUser;
import com.whoisdm.characterFolder.model.user.User;

public interface UserService {
    User save(RegistrationUser user);

}
