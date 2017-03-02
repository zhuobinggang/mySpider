package com.kobako.re0;

import com.kobako.SpiderUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by kobako on 2017/3/1.
 * Just a game
 */
public class Re0Spider {
    Re0Spider(Builder builder){
        this.selector = builder.selector;
        this.minTextLength = builder.minTextLength;
    }

    private String selector;
    private int minTextLength;

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
        return SpiderUtil.getPageContent(realURL);
    }

    private String getNecesarryContentByJsoup(String content){
        Document doc = Jsoup.parse(content);
        Elements elements = doc.select(selector);
        StringBuilder sb = new StringBuilder();
        elements.forEach(it->{
            if(it.text().length()>minTextLength){
                sb.append(it.text());
                sb.append("\n\r");
            }
        });
        sb.append("\n\r");
        return sb.toString();
    }

    public static class Builder{
        private String selector;
        private int minTextLength;

        public Builder(){
            selector = "div[class*=d_post_content j_d]";
            minTextLength = 20;
        }

        public Builder selector(String selector){
            this.selector = selector;
            return this;
        }

        public Builder minTextLength(int minTextLength){
            this.minTextLength = minTextLength;
            return this;
        }

        public Re0Spider build(){
            return new Re0Spider(this);
        }
    }
}
