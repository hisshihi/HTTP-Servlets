package server;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class HttpClientRunner {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Создание экземпляра HttpClient с использованием версии HTTP 1.1
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        // Создание экземпляра HttpRequest для отправки POST запроса
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9000")) // Установка URI для запроса
                .header("Content-Type", "application/json") // Установка заголовка Content-Type
                .POST(BodyPublishers.ofFile(Path.of("resources", "first.json"))) // Установка тела запроса из файл
                .build();

        // Отправка запроса и получение ответа в виде строки
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.headers());
        System.out.println(response.body());
    }

}
