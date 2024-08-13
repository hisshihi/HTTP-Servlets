package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramRunner {
    public static void main(String[] args) throws IOException {
        // UDP клиент
        // Получаем объект InetAddress, представляющий хост с именем "localhost"
        InetAddress inetAddresses = InetAddress.getByName("localhost");

        // Создаем и автоматически закрываем DatagramSocket, используя try-with-resources
        try (var datagramSocket = new DatagramSocket()) {
            // Преобразуем строку сообщения в массив байтов
            byte[] bytes = "Hello from UDP client".getBytes();

            // Создаем DatagramPacket для отправки данных. Указываем массив байтов, его длину, адрес и порт
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, inetAddresses, 7777);

            // Отправляем пакет через сокет
            datagramSocket.send(packet);
        }
    }
}