package uos.urbanscience.ijddc.domain.port.in;

import uos.urbanscience.ijddc.domain.value.user.User;

public interface AuthorizationPort {
    User CheckAuthorization(String token);
}
