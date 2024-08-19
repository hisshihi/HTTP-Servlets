package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Установка заголовка ответа, указывающего, что содержимое ответа должно быть предложено к скачиванию как файл.
        // Здесь filename.txt - это имя файла, которое будет предложено пользователю при скачивании.
        resp.setHeader("Content-Disposition", "attachment; filename=\"filename.txt\"");

        // Установка типа содержимого (MIME type) ответа. В данном случае указывается, что содержимое ответа будет в формате JSON.
        resp.setContentType("application/json");

        // Установка кодировки символов для содержимого ответа. Указывается, что для чтения содержимого ответа следует использовать UTF-8.
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        // Создание потока вывода (ServletOutputStream), через который будут передаваться данные клиенту.
        try (ServletOutputStream outputStream = resp.getOutputStream();
             // Загрузка файла first.json из ресурсов проекта. InputStream используется для чтения данных из файла.
             InputStream stream = DownloadServlet.class.getClassLoader().getResourceAsStream("first.json")
        ) {
            // Чтение всех байт из файла first.json и их запись в поток ответа. Это инициирует скачивание файла.
            outputStream.write(stream.readAllBytes());
        }
    }

}
