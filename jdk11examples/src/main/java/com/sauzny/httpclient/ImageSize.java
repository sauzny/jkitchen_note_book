package com.sauzny.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.zip.GZIPInputStream;

/***************************************************************************
 *
 * ███████╗ █████╗ ██╗   ██╗███████╗███╗   ██╗██╗   ██╗
 * ██╔════╝██╔══██╗██║   ██║╚══███╔╝████╗  ██║╚██╗ ██╔╝
 * ███████╗███████║██║   ██║  ███╔╝ ██╔██╗ ██║ ╚████╔╝ 
 * ╚════██║██╔══██║██║   ██║ ███╔╝  ██║╚██╗██║  ╚██╔╝  
 * ███████║██║  ██║╚██████╔╝███████╗██║ ╚████║   ██║   
 * ╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝   ╚═╝   
 *
 * @时间: 2018/12/11 - 14:20
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class ImageSize {

    public static void get(HttpClient client, String uri) throws IOException, InterruptedException {

        var request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();


        HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());


        BufferedReader reader = new BufferedReader(new InputStreamReader(response.body(),"utf-8"));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null){
            sb.append(line);
        }
        String shaibi = sb.toString();

        System.out.println(shaibi.length());

    }

    public static void main(String[] args) throws IOException, InterruptedException {

        var client = HttpClient.newHttpClient();

        var urit = "http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJUCfWcM6AA8OED0s4nEFp0gUftRm4XlQl75AdlllRdesqac5MQPP52vnEb8RqicJSvvTQsrGPIrJA/132";

        ImageSize.get(client, urit);


    }
}
