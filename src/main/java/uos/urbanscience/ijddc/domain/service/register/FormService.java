package uos.urbanscience.ijddc.domain.service.register;

public class FormService {
    private final String phonePattern = "^\\d{3}-\\d{3,4}-\\d{4}$";
    private final String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private final String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#])[A-Za-z\\d!@#]{8,}$";
    public boolean isPhoneValid(String phone) {
        return phone.matches(this.phonePattern);
    }
    public boolean isEmailValid(String email) {
        return email.matches(this.emailPattern);
    }
    public boolean isPassValid(String pass) {
        return pass.matches(this.passwordPattern);
    }

}
