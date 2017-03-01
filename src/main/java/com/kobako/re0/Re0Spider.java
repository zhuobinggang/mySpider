package com.kobako.re0;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kobako on 2017/3/1.
 * Just a game
 */
public class Re0Spider {
    OkHttpClient client = new OkHttpClient();

    public String getNeed(String url, int startPage, int endPage){
        StringBuilder sb = new StringBuilder();
        try{
            for(int i=startPage;i<=endPage;i++){
                sb.append(
                        getNecesarryContentByJsoup(
                                getContentFromOnePage(url,i)
                        )
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }



    private String getContentFromOnePage(String url,int page)
    throws IOException{
        String realURL = url+"?pn="+page;
        System.out.println(realURL);
        Request request = new Request.Builder()
                .url(realURL)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();//被坑 这里是string不是toString
    }

    private String getNecesarryContentByJsoup(String content){
        String className = "d_post_content j_d_post_content ";
        Document doc = Jsoup.parse(content);
//        Elements elements = doc.getElementsByClass(className);
        Elements elements = doc.select("div[class*=d_post_content j_d]");
//        List<String> contents = new ArrayList<>();
//        elements.forEach(it->{
//            contents.add(it.text());
//        });
        StringBuilder sb = new StringBuilder();
        elements.forEach(it->{
            if(it.text().length()>20){
                sb.append(it.text());
                sb.append("\n\r");
            }
        });
        sb.append("\n\r");
        return sb.toString();
    }
}
