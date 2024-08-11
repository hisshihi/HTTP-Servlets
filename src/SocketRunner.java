import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketRunner {

    public static void main(String[] args) throws UnknownHostException {

        // Получаем IP-адрес для доменного имени "leon-studio.ru" с использованием IPv4
        InetAddress inetAddress = Inet4Address.getByName("localhost");

        // Создаем сокет для соединения с указанным IP-адресом и портом 80 (типичный порт для HTTP)
        try (
                // Создаем сокет для работы с TCP соединением
                Socket socket = new Socket(inetAddress, 7777);
                // Создаем поток для отправки данных через сокет
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                // Создаем поток для чтения данных через сокет
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

                Scanner scanner = new Scanner(System.in);
        ) {

//            Добавляем мессанджер
            while (scanner.hasNextLine()) {
                // Отправляем запрос на сервер
                String request = scanner.nextLine();
                dataOutputStream.writeUTF(request);

                // Получаем ответ
                String response = dataInputStream.readUTF();
                System.out.println("Request from server: " + response);
            }

            // Отправляем строку "Hello World" через сокет
//            dataOutputStream.writeUTF("Hello World");

            // Читаем все байты из входного потока
//            byte[] response = dataInputStream.readAllBytes();

//            Получаем ответ от сервера
//            String response = dataInputStream.readUTF();

            // Выводим ответ
//            System.out.println("Response from server: " + response);
        } catch (IOException e) {
            // Если возникает ошибка ввода-вывода, выбрасываем исключение
            throw new RuntimeException(e);
        }
    }

}
