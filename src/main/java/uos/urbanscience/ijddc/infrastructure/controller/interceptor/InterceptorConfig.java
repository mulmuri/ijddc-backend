package uos.urbanscience.ijddc.infrastructure.controller.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private AuthInterceptor authInterceptor;

    @Autowired
    private ManagerInterceptor managerInterceptor;
    @Autowired
    private MemberInterceptor memberInterceptor;
    @Autowired
    private ContributorInterceptor contributorInterceptor;

    @Autowired
    private ReviewerInterceptor reviewerInterceptor;
    @Autowired
    private EditorInterceptor editorInterceptor;
    @Autowired
    private PublicInterceptor publicInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);
        registry.addInterceptor(managerInterceptor).addPathPatterns("/manager/**");
        registry.addInterceptor(memberInterceptor).addPathPatterns("/member/**");
        registry.addInterceptor(contributorInterceptor).addPathPatterns("/contributor/**");
        registry.addInterceptor(reviewerInterceptor).addPathPatterns("/reviewer/**");
        registry.addInterceptor(editorInterceptor).addPathPatterns("/editor/**");
        registry.addInterceptor(publicInterceptor).addPathPatterns("/public/**");
    }
}
