package uos.urbanscience.ijddc.infrastructure.controller.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import uos.urbanscience.ijddc.exception.httpstatus.UnauthorizedException;

@Component
public class ManagerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean isManager = (boolean) request.getAttribute("isManager");
        if (isManager == false) {
            throw new UnauthorizedException("User not authenticated");
        }
        return true;
    }
}
