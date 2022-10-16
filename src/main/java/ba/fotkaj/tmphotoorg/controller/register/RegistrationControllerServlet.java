package ba.fotkaj.tmphotoorg.controller.register;

import ba.fotkaj.tmphotoorg.controller.router.Routes;
import ba.fotkaj.tmphotoorg.ejb.town.entity.Town;
import ba.fotkaj.tmphotoorg.ejb.town.service.TownService;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "registrationControllerServlet", value = "/registration")
public class RegistrationControllerServlet extends HttpServlet {

    @Inject
    private TownService townService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        List<Town> townList = townService.findAll();
        request.setAttribute("townList", townList );
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.REGISTRATION_FORM);
        requestDispatcher.forward(request, response);
    }
}
