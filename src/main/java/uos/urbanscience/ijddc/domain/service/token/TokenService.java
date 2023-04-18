package uos.urbanscience.ijddc.domain.service.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uos.urbanscience.ijddc.domain.value.user.Tokens;
import uos.urbanscience.ijddc.domain.value.user.User;

@Service
public class TokenService {

    AccessTokenService accessService;
    RefreshTokenService refreshService;

    @Autowired
    public TokenService(AccessTokenService accessService, RefreshTokenService refreshService) {
        this.accessService = accessService;
        this.refreshService = refreshService;
    }

    public Tokens generateTokens(User user) {
        String access = accessService.generateToken(user);
        String refresh = refreshService.generateToken(user);

        return new Tokens(access, refresh);
    }
}
