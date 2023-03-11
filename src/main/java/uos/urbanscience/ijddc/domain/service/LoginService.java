package uos.urbanscience.ijddc.domain.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LoginService {
    public void Login(String id, String pw) {

    }

    public void Logout(int userid) {

    }

    public void ChangePass() {

    }

    public void InitPass(long userid) {

    }

    private void ComparePass(String rawPassword, String hashedPass) {
        // 비밀번호 해싱
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(rawPassword);

// 비밀번호 비교
        boolean isMatch = encoder.matches(rawPassword, encodedPassword);


    }
}
