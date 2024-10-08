package server;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpClientRunner {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
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
        CompletableFuture<HttpResponse<String>> response1 = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        CompletableFuture<HttpResponse<String>> response2 = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        CompletableFuture<HttpResponse<String>> response3 = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response3.get().body());
//        System.out.println(response.headers());
//        System.out.println(response.body());
    }

}
