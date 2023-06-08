package uos.urbanscience.ijddc.domain.usecase.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uos.urbanscience.ijddc.domain.service.token.TokenService;
import uos.urbanscience.ijddc.domain.value.user.Tokens;
import uos.urbanscience.ijddc.domain.value.user.UserLoginValue;


@Service
@RequiredArgsConstructor
public class LoginUseCase {

    private final TokenService tokenService;

    public Tokens Login(UserLoginValue value) {
        // input : email, pw
        // create token
        //
        return tokenService.generateTokens(value.);
    }
}

