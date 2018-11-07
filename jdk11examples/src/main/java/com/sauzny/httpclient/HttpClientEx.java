package com.sauzny.httpclient;

import org.springframework.util.StopWatch;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

// https://www.youtube.com/watch?v=sZSdWq490Vw demo视频

public class HttpClientEx {

    // 我测试了一个get觉得性能不好，其余的我就不测试了
    // http http2 websocket 都有client

    public static void get(HttpClient client) throws IOException, InterruptedException {

        StopWatch task = new StopWatch("jdk11 http get demo");

        var uri = "https://api.github.com/users/sauzny/repos";

        task.start();

        // 这个变量实际情况下应该是每次都是new的 因为参数不同
        // 这个变量的创建不是很耗时 0-3ms，所以我没有把这个全局初始化
        // request构建之后是不可变的，但是可以被发送多次
        var request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        task.stop();

        task.start();

        // 已经全局初始化过了，很快
        //var client = HttpClient.newHttpClient();

        task.stop();

        task.start();

        // 本机postman  记录 805 566 517 546
        // 本机浏览器    记录 799 519 485 504 547

        // 这个执行比较慢 记录 1509 1104 1343 1263 1218
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        task.stop();

        System.out.println(task.prettyPrint());

        System.out.println(response.statusCode());
    }

    public static void post(){
        HttpRequest.newBuilder()
                .uri(URI.create(""))
                .POST(HttpRequest.BodyPublishers.ofString("", StandardCharsets.UTF_8))
                .build();
        // 这个当然也可以上传文件或者Multipart
    }

    public static void main(String[] args) {

        // 初始化这个client需要的时间比较长 500ms左右，应该有些东西是JVM全局初始
        // 在这执行之后，后面的get里就会是0-1ms
        // Once build 一个 httpclient 可以发送多次请求
        var client = HttpClient.newHttpClient();

        try {
            for(int i=0; i<5; i++){
                // 测试的结果看 很不好
                HttpClientEx.get(client);
                Thread.sleep(3*1000L);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
