package com.kobako;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by kobako on 2017/3/2.
 * Just a game
 */
public class SpiderUtil {
    static OkHttpClient client = new OkHttpClient();

    /**
     * get page content from URL
     * @param URL
     * @return
     * @throws IOException
     */
    public static String getPageContent(String URL)
    throws IOException{
        Request request = new Request.Builder()
                .url(URL)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();//被坑 这里是string不是toString
    }

    /**
     * write content out to outputPath
     * @param content
     * @param outputPath
     * @throws IOException
     */
    public static void writeOutToPath(String content,String outputPath)
    throws IOException{
        Path path = Paths.get(outputPath);
        Files.write(path,content.getBytes(),StandardOpenOption.CREATE_NEW,StandardOpenOption.APPEND);
    }
}
