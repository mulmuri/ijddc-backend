package uos.urbanscience.ijddc.domain.port.in;

import uos.urbanscience.ijddc.domain.value.user.Tokens;
import uos.urbanscience.ijddc.domain.value.user.UserRegisterValue;

public interface RegisterPort {
    public Tokens RequestRegister(UserRegisterValue account);

}
