package uos.urbanscience.ijddc.domain.usecase.auth;


import org.springframework.beans.factory.annotation.Autowired;
import uos.urbanscience.ijddc.domain.exception.AuthorizationFailedException;
import uos.urbanscience.ijddc.domain.port.in.AuthorizationPort;
import uos.urbanscience.ijddc.domain.service.token.AccessTokenService;
import uos.urbanscience.ijddc.domain.service.token.RefreshTokenService;
import uos.urbanscience.ijddc.domain.value.user.User;

public class AuthorizationUseCase implements AuthorizationPort {

    private AccessTokenService accessService;
    private RefreshTokenService refreshService;

    @Autowired
    public AuthorizationUseCase(AccessTokenService accessTokenService, RefreshTokenService refreshTokenService) {
        this.accessService = accessTokenService;
        this.refreshService = refreshTokenService;
    }

    public User CheckAuthorization(String token) {

        if (accessService.validateToken(token)) {
            return accessService.extractUser(token);
        }

        if (refreshService.validateToken(token)) {
            return refreshService.extractUser(token);
        }

        throw new AuthorizationFailedException("invalid token or token expired");
    }
}
