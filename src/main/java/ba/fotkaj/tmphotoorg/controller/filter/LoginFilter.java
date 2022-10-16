package ba.fotkaj.tmphotoorg.controller.filter;


import ba.fotkaj.tmphotoorg.controller.login.UserSession;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter(urlPatterns = {"/dashboard/*"})
public class LoginFilter implements Filter {

    private ServletContext context;
    public void init(FilterConfig fConfig ) throws ServletException{
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }



    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        this.context.log("doFilter je pozvan");
        if (UserSession.USER.getFromSession(request) == null) {
            response.sendRedirect(request.getContextPath() + "/login");

        }else{
            chain.doFilter(request,response);
        }
    }
}
