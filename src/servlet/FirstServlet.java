package servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// Определяем сервлет и привязываем его к URL /first
@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    // Метод init вызывается один раз при инициализации сервлета. Обычно используется для выполнения начальной настройки.
    @Override
    public void init(ServletConfig config) throws ServletException {
        // Вызов родительского метода init для стандартной инициализации
        super.init(config);
    }

    // Метод service обрабатывает все типы запросов (GET, POST и др.). Обычно переопределяется для обработки всех типов запросов одинаково.
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Вызов родительского метода service, который делегирует обработку запросов методам doGet, doPost и др.
        super.service(req, resp);
    }

    // Переопределяем метод doGet для обработки GET запросов
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Устанавливаем тип контента ответа в HTML
        resp.setContentType("text/html");
        // Получаем объект PrintWriter для отправки данных в ответе
        try (PrintWriter writer = resp.getWriter()) {
            // Записываем HTML-код в ответ
            writer.write("<h1>Hello from First Servlet</h1>");
        }
    }

    // Метод destroy вызывается один раз при завершении работы сервлета. Обычно используется для освобождения ресурсов.
    @Override
    public void destroy() {
        // Вызов родительского метода destroy для стандартного завершения работы
        super.destroy();
    }
}
