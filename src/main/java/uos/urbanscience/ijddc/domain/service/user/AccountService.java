package uos.urbanscience.ijddc.domain.service.user;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import uos.urbanscience.ijddc.domain.value.user.User;
import uos.urbanscience.ijddc.domain.value.user.UserRegisterValue;

@Component
public class AccountService {

    public User getUser(Long userId) {

    }

    @Transactional
    public long createAccount(UserRegisterValue user) {

    }

    public boolean isEmailExist(String email) {

    }
}
