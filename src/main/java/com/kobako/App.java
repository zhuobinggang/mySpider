package com.kobako;

import com.kobako.re0.Re0Spider;

import java.io.IOException;

/**
 * Created by kobako on 2017/3/2.
 * Just a game
 */
public class App {
    public static void main(String[] args) {
        //create spider to get content from "Baidu Post Bar"
        Re0Spider spider = new Re0Spider.Builder().minTextLength(0).build();

        String url = "https://tieba.baidu.com/p/4950684707";
        String outputPath = "C:\\Users\\zhuo\\Desktop\\testIt.txt";
        int startPage = 1;
        int endPage = 1;

        //get content you need
        String content = spider.getNeed(url,startPage,endPage);

        try {//write out to file
            SpiderUtil.writeOutToPath(content,outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
