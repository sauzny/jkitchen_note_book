package com.sauzny.httpclient;

import org.springframework.util.StopWatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
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
 * @时间: 2018/12/5 - 15:42
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class Tianqi {

    public static void get(HttpClient client, String uri, int i) throws IOException, InterruptedException {

        var request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .setHeader("Accept-Encoding", "gzip, deflate")
                .GET()
                .build();


        HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

        InputStream stream = new GZIPInputStream(response.body());

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream,"gbk"));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null){
            sb.append(line);
        }
        String shaibi = sb.toString()
                .substring(16, sb.toString().length()-1)
                .replaceAll("'","\"")
                .replaceAll("\\{","{\"")
                .replaceAll(",",",\"")
                .replaceAll(":","\":")
                .replaceAll(",\"\\{",",{")
                .replaceAll("\\{\"}", "{}")
                ;

        //System.out.println(shaibi);

        Weather weather = JacksonUtils.nonNull().fromJson(shaibi, Weather.class);

        weather.getTqInfo().forEach(tqInfo -> {
            if(tqInfo.getFengxiang() != null) System.out.println(i + "\t" + tqInfo.getFengxiang());
        });

    }

    public static void main(String[] args) throws IOException, InterruptedException {

        var client = HttpClient.newHttpClient();

        var urit = "http://tianqi.2345.com/t/wea_history/js/%s/54527_%s.js";

        for(int i=201801; i<201813; i++){
            String uri = String.format(urit, i, i);
            //System.out.println(uri);
            Tianqi.get(client, uri, i);

            //System.out.println();
        }


    }
}
