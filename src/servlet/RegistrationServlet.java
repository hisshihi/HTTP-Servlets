package servlet;

import dto.CreateUserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service.UserService;

import java.io.IOException;
import java.util.List;

// Аннотация для принятия файлов
@MultipartConfig(fileSizeThreshold = 1024 * 1024)
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", List.of("USER", "ADMIN"));
        req.setAttribute("genders", List.of("MALE", "FEMALE"));


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Получение файла из frontend
//        Part image = req.getPart("image");

        CreateUserDto userDto = CreateUserDto.builder()
                .name(req.getParameter("name"))
                .image(req.getPart("image"))
                .birthday(req.getParameter("birthday"))
                .gender(req.getParameter("gender"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .role(req.getParameter("role"))
                .build();

        userService.create(userDto);
        resp.sendRedirect("/login");
    }
}
