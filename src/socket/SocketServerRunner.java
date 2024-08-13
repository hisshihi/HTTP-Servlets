package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerRunner {
    public static void main(String[] args) {
//        Является хостом, к котому будут идти запросы клиентов.
        try (
                ServerSocket serverSocket = new ServerSocket(7777);
//                Кто подключился
                Socket socket = serverSocket.accept();
//                Поток ввода
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
//                Поток вывода
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());

                Scanner scanner = new Scanner(System.in);
        ) {

            String request = inputStream.readUTF();
            String helloMessage = "Hello, I'm a server. Write \"stop\" so that I stop.";
            outputStream.writeUTF(helloMessage);
            while (!"stop".equals(request)) {
//            Читаем строку от клиента
//                String clientMessage = inputStream.readUTF();
                System.out.println("Client request: " + request);

                String response = scanner.nextLine();

                // Отправляем ему ответ
                outputStream.writeUTF(response);
                request = inputStream.readUTF();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
