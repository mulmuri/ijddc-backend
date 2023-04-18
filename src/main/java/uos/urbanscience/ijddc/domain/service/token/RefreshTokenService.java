package uos.urbanscience.ijddc.domain.service.token;


import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import uos.urbanscience.ijddc.domain.value.user.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Component
public class RefreshTokenService extends TokenServiceAbstract {

    @Value("${ACCESS_KEY}")
    private String secret;

    @Override
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userid", user.getUserId());
        claims.put("role", user.getUserRole().ToCode());
        return createToken(claims, Long.toString(user.getUserId()));
    }

    public boolean validateToken(String token) {
        boolean isNotExpired = extractExpiration(token).before(new Date());

        User user = new User((long)0, 0);
        boolean isNotModified = extractUser(token).equals(user);

        return (isNotExpired && isNotModified);
    }

    public User extractUser(String token) {
        Long userId = extractUserId(token);
        int role = extractUserRole(token);
        return new User(userId, role);
    }

    private Long extractUserId(String token) {
        return extractClaim(token, claims -> claims.get("userid", Long.class));
    }

    private int extractUserRole(String token) {
        return extractClaim(token, claims -> claims.get("role", int.class));
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private  <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        return super.extractClaim(token, claimsResolver, secret);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return super.createToken(claims, subject, secret);
    }
}
