package uos.urbanscience.ijddc.domain.port.in;

import uos.urbanscience.ijddc.domain.value.user.UserAccount;
import uos.urbanscience.ijddc.domain.value.user.UserRole;

import java.util.List;

public interface AccountPort {
    UserAccount getUserAccount(long userId);
    List<UserAccount> getALlUserAccount();
    void updateUserAccount(long userId, UserAccount account);
    void updateUserRole(long userId, UserRole role, boolean flag);
}
