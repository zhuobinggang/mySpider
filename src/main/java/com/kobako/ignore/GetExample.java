package com.kobako.ignore;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by kobako on 2017/2/28.
 * Just a game
 */
public class GetExample {
    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws IOException {
        GetExample example = new GetExample();
        String response = example.run("https://tieba.baidu.com/p/4472374288?pn=1");
        System.out.println(response);
    }
}
