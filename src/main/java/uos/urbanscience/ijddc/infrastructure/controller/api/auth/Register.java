package uos.urbanscience.ijddc.infrastructure.controller.api.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uos.urbanscience.ijddc.domain.port.in.RegisterPort;
import uos.urbanscience.ijddc.domain.value.user.Tokens;
import uos.urbanscience.ijddc.domain.value.user.UserRegisterValue;

@RestController
@RequestMapping("/auth/register/submit")
public class Register {

    @Autowired
    private RegisterPort service;

    private record RegisterInput(String email, String passwd, String name, String phone, String affiliation, String rank) {};
    private record RegisterOutput(String accessToken, String RefreshToken) {};

    @PostMapping
    public RegisterOutput Register(@RequestBody RegisterInput input) {
        Tokens output = service.RequestRegister(new UserRegisterValue(input.name, input.email, input.phone, input.affiliation, input.passwd, input.rank));
        return new RegisterOutput(output.access(), output.refresh());
    }
}
