package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServerRunner {
    public static void main(String[] args) throws IOException {
        // UDP сервер
        // Создаем и автоматически закрываем DatagramSocket, привязанный к порту 7777, используя try-with-resources
        try (DatagramSocket datagramSocket = new DatagramSocket(7777)) {
            // Создаем буфер для приема данных размером 512 байтов
            byte[] buffer = new byte[100];

            // Создаем DatagramPacket для приема данных, используя созданный буфер
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Получаем данные в пакет через сокет
            datagramSocket.receive(packet);

            // Преобразуем полученные байты в строку и выводим на консоль
            System.out.println(new String(buffer));
        }
    }
}

