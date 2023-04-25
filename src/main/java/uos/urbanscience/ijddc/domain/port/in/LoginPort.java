package uos.urbanscience.ijddc.domain.port.in;

import uos.urbanscience.ijddc.domain.value.user.Tokens;
import uos.urbanscience.ijddc.domain.value.user.UserLoginValue;

public interface LoginPort {
    Tokens Login(UserLoginValue user);
}
