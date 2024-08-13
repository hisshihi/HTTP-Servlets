package client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlExample {

    public static void main(String[] args) throws IOException {

        // Создание объекта URL для локального файла
        URL url = new URL("file:D:\\work\\java\\HTTPServlets\\src\\socket\\DatagramRunner.java");

        // Открытие соединения с указанным URL
        URLConnection connection = url.openConnection();

        // Чтение всех байтов из входящего потока соединения и преобразование их в строку для вывода
        System.out.println(new String(connection.getInputStream().readAllBytes()));

    }

    private static void checkSite() throws IOException {
        // Создание объекта URL для указанного веб-сайта
        URL url = new URL("https://leon-studio.ru");

        // Открытие соединения с указанным URL
        URLConnection urlConnection = url.openConnection();

        // Установка флага, что соединение будет использоваться для вывода данных
        urlConnection.setDoOutput(true);

        // Попытка открытия выходного потока для записи данных в соединение
        try (OutputStream outputStream = urlConnection.getOutputStream()) {
            // В данном случае ничего не записывается в выходной поток
        }

        // Получение и вывод заголовков ответа от сервера (закомментировано)
        // System.out.println(urlConnection.getHeaderFields());
    }

}
