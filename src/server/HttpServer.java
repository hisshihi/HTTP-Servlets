package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpServer {

    private final int PORT;

    public HttpServer(int PORT) {
        this.PORT = PORT;
    }

    // При вызове метода run создаём сервер
    public void run() {
        try {
            // Идёт создание сервера и бронирование порта
            ServerSocket serverSocket = new ServerSocket(PORT);
            // Ждём запрос
            Socket socket = serverSocket.accept();
            // Обработка запроса
            processSocket(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processSocket(Socket socket) {
        try (socket;
             DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {

//            Шаг 1 - обработать request
            System.out.println("Request: " + new String(inputStream.readNBytes(400)));

//            Шаг 2 - создание response
            byte[] body = Files.readAllBytes(Path.of("resources", "example.html"));
            byte[] headers = """
                    HTTP/1.1 200 OK
                    Content-Type: text/html
                    Content-Length: %s
                    """.formatted(body.length).getBytes();
            outputStream.write(headers);
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write(body);
        } catch (IOException e) {
//            TODO: 14.08.2024 - обработать ошибку
            e.printStackTrace();
        }
    }
}
