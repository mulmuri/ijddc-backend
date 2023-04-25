package uos.urbanscience.ijddc.domain.usecase.auth;

import uos.urbanscience.ijddc.domain.exception.AuthorizationFailedException;
import uos.urbanscience.ijddc.domain.port.in.RegisterPort;
import uos.urbanscience.ijddc.domain.service.register.FormService;
import uos.urbanscience.ijddc.domain.service.token.TokenService;
import uos.urbanscience.ijddc.domain.service.user.AccountService;
import uos.urbanscience.ijddc.domain.value.user.Tokens;
import uos.urbanscience.ijddc.domain.value.user.User;
import uos.urbanscience.ijddc.domain.value.user.UserRegisterValue;
import uos.urbanscience.ijddc.domain.value.user.UserRole;

public class RegisterUseCase implements RegisterPort {

    FormService formService;
    TokenService tokenService;
    AccountService accountService;

    public Tokens RequestRegister(UserRegisterValue account) {
        if (!formService.isEmailValid(account.email())) {
            throw new AuthorizationFailedException("email pattern is not matched");
        }

        if (!formService.isPhoneValid(account.phone())) {
            throw new AuthorizationFailedException("phone pattern is not matched");
        }

        if (!formService.isPassValid(account.password())) {
            throw new AuthorizationFailedException("password pattern is not matched");
        }

        if (accountService.isEmailExist(account.email())) {
            throw new RuntimeException();
        }

        long userId = accountService.createAccount(account);

        User user = new User(userId, UserRole.Default().ToCode());

        Tokens tokens = tokenService.generateTokens(user);

        return tokens;
    }

    public void UnregisterService() {
        // set user status 0
    }
}
