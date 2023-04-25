package uos.urbanscience.ijddc.infrastructure.controller.api.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uos.urbanscience.ijddc.domain.port.in.LoginPort;
import uos.urbanscience.ijddc.domain.value.user.Tokens;
import uos.urbanscience.ijddc.domain.value.user.UserLoginValue;

@RestController
@RequestMapping("/auth/login")
public class Login {

    @Autowired
    LoginPort service;

    private record LoginInput(String userId, String passwd) {}
    private record LoginOutput() {}

    @PostMapping @ResponseBody
    public LoginOutput Login(@RequestBody LoginInput input) {
        Tokens output = service.Login(new UserLoginValue(input.userId, input.passwd));
        return new LoginOutput();
    }

}
