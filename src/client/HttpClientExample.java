package client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

import static java.net.http.HttpResponse.*;

public class HttpClientExample {

    public static void main(String[] args) throws IOException, InterruptedException {
//        HttpClient для отправки запросов и получение ответов.
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        // Создание get запроса
        HttpRequest getRequest = HttpRequest.newBuilder(URI.create("https://leon-studio.ru"))
                .GET()
                .build();

        // Создание post запроса и отправки файла
        HttpRequest postRequest = HttpRequest.newBuilder(URI.create("https://leon-studio.ru"))
                .POST(BodyPublishers.ofFile(Path.of("D:\\work\\java\\HTTPServlets\\src\\socket\\DatagramRunner.java")))
                .build();

        // Отправка синхронно запроса и преобразование ответа в строку
        HttpResponse<String> httpResponse = httpClient.send(postRequest, BodyHandlers.ofString());
        // Вывод заголовка ответа
        System.out.println(httpResponse.headers());
        // Вывод тела ответа
        System.out.println(httpResponse.body());
    }

}
