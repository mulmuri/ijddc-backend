package uos.urbanscience.ijddc.domain.value.user;

import lombok.Getter;

import java.util.Objects;

@Getter
public class User {

    private long userId;
    private UserRole userRole;

    public User(long userId, int roleCode) {
        this.userRole = new UserRole(roleCode);
        this.userId = userId;
    }

    public boolean hasRole(Role role) {
        return this.userRole.hasRole(role);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return (userId == user.userId && userRole.ToCode() == user.userRole.ToCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userRole.ToCode());
    }

}
