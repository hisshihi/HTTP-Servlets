package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {

    private final ExecutorService pool;
    private final int PORT;
    private boolean stopped;

    public HttpServer(int PORT, int poolSize) {
        this.PORT = PORT;
        this.pool = Executors.newFixedThreadPool(poolSize);
    }

    // При вызове метода run создаём сервер
    public void run() {
        try {
            // Идёт создание сервера и бронирование порта
            ServerSocket serverSocket = new ServerSocket(PORT);
//            Пока сервер не стопнут, принимаются все запросы
            while (!stopped) {
                // Ждём запрос
                Socket socket = serverSocket.accept();
                System.out.println("Socket accepted");
                // Обработка запроса в кол-ве poolSize
                pool.submit(() -> processSocket(socket));
            }
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

            Thread.sleep(10000);

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
        } catch (IOException | InterruptedException e) {
//            TODO: 14.08.2024 - обработать ошибку
            e.printStackTrace();
        }
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
