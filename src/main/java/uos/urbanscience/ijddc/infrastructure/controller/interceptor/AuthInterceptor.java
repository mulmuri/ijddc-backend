package uos.urbanscience.ijddc.infrastructure.controller.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import uos.urbanscience.ijddc.domain.exception.AuthorizationFailedException;
import uos.urbanscience.ijddc.domain.port.in.AuthorizationPort;
import uos.urbanscience.ijddc.domain.usecase.auth.AuthorizationUseCase;
import uos.urbanscience.ijddc.domain.value.user.Role;
import uos.urbanscience.ijddc.domain.value.user.User;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    AuthorizationPort useCase;

    @Autowired
    public AuthInterceptor(AuthorizationUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return false;
        }
        try {
            User user = useCase.CheckAuthMiddleware(token);

            request.setAttribute("userId", user.getUserId());
            request.setAttribute("isMember", user.hasRole(Role.member));
            request.setAttribute("isManager", user.hasRole(Role.manager));
            request.setAttribute("isContributor", user.hasRole(Role.contributor));
            request.setAttribute("isReviewer", user.hasRole(Role.reviewer));
            request.setAttribute("isEditor", user.hasRole(Role.editor));

            return true;

        } catch (AuthorizationFailedException e) {
            return false;
        }
    }
}
