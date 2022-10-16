package ba.fotkaj.tmphotoorg.controller.dashboard.photoshooting;

import ba.fotkaj.tmphotoorg.controller.login.UserSession;
import ba.fotkaj.tmphotoorg.controller.router.Routes;
import ba.fotkaj.tmphotoorg.ejb.photoshoot.entity.Reservation;
import ba.fotkaj.tmphotoorg.ejb.photoshoot.resrevation.ReservationService;
import ba.fotkaj.tmphotoorg.ejb.user.entity.User;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "photoshootControllerServlet", value = "/photoshoot")
public class PhotoshootControllerServlet extends HttpServlet {


    @Inject

    private ReservationService reservationService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User userSession = UserSession.USER.getFromSession(request);
        if (userSession != null) {

            List<Reservation> reservationList = reservationService.findByUserCreator(userSession);
            request.setAttribute("rezeravcije", reservationList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.PHOTOSHOOT);
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.LOGIN);
            requestDispatcher.forward(request, response);
        }

    }
}
