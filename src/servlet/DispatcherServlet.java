package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/flights")
//                .forward(req, resp);

//        Все headers спадывают
//        req.getRequestDispatcher("/flights")
//                        .include(req, resp);

        // Происходит полноценный редирект с сменой url
        resp.sendRedirect("/flights");

        System.out.println();

        // Можно добавить свои атрибуты
//        req.setAttribute("1", "234");
//        requestDispatcher.forward(req, resp);
    }
}
