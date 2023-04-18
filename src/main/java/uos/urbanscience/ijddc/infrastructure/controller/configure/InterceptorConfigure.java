package uos.urbanscience.ijddc.infrastructure.controller.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import uos.urbanscience.ijddc.infrastructure.controller.interceptor.*;

public class InterceptorConfigure implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;
    @Autowired
    private ContributorInterceptor contributorInterceptor;
    @Autowired
    private ReviewerInterceptor reviewerInterceptor;
    @Autowired
    private EditorInterceptor editorInterceptor;
    @Autowired
    private MemberInterceptor memberInterceptor;
    @Autowired
    private ManagerInterceptor managerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);

        registry.addInterceptor(contributorInterceptor).addPathPatterns("/contributor/**");
        registry.addInterceptor(reviewerInterceptor).addPathPatterns("/reviewer/**");
        registry.addInterceptor(editorInterceptor).addPathPatterns("/editor/**");
        registry.addInterceptor(memberInterceptor).addPathPatterns("/member/**");
        registry.addInterceptor(managerInterceptor).addPathPatterns("/manager/**");
    }
}
