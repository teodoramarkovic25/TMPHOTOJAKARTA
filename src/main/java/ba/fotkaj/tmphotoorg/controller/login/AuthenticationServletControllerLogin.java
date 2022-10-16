package ba.fotkaj.tmphotoorg.controller.login;

import ba.fotkaj.tmphotoorg.controller.router.Routes;
import ba.fotkaj.tmphotoorg.ejb.user.entity.User;
import ba.fotkaj.tmphotoorg.ejb.user.service.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AuthenticationServletControllerLogin", value = "/authentication")
public class AuthenticationServletControllerLogin extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(username, password);
        if(user==null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.LOGIN);
            requestDispatcher.forward(request,response);

        }else{
            UserSession.USER.addToSession(user,request);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.DASHBOARD_ACCESS);
            requestDispatcher.forward(request,response);

        }
    }
}
