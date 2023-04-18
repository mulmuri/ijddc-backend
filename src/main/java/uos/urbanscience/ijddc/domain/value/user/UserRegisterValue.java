package uos.urbanscience.ijddc.domain.value.user;

public record UserRegisterValue(
        String name,
        String email,
        String phone,
        String affiliation,
        String password,
        String rank) {

}