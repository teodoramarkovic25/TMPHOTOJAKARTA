package ba.fotkaj.tmphotoorg;

import java.io.*;
import java.util.List;

import ba.fotkaj.tmphotoorg.ejb.user.entity.User;
import ba.fotkaj.tmphotoorg.ejb.user.service.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;


    @Inject
    private UserService userService;



    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");



        List<User> users = userService.findAll();
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<ul>");
       for(User user : users){
            out.println("<li>" + user.getName()+"</li>");
        }
        out.println("</ul>");


        out.println("</body></html>");
    }

    public void destroy() {
    }
}