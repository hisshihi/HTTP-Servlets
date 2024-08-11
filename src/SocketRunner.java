import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketRunner {

    public static void main(String[] args) throws UnknownHostException {

        // Получаем IP-адрес для доменного имени "leon-studio.ru" с использованием IPv4
        InetAddress inetAddress = Inet4Address.getByName("leon-studio.ru");

        // Создаем сокет для соединения с указанным IP-адресом и портом 80 (типичный порт для HTTP)
        try (
                // Создаем сокет для работы с TCP соединением
                Socket socket = new Socket(inetAddress, 80);
                // Создаем поток для отправки данных через сокет
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                // Создаем поток для чтения данных через сокет
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        ) {
            // Отправляем строку "Hello World" через сокет
            dataOutputStream.writeUTF("Hello World");

            // Читаем все байты из входного потока
            byte[] response = dataInputStream.readAllBytes();

            // Выводим длину полученного ответа на экран
            System.out.println(response.length);
        } catch (IOException e) {
            // Если возникает ошибка ввода-вывода, выбрасываем исключение
            throw new RuntimeException(e);
        }
    }

}
