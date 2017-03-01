package com.kobako.re0;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 * Created by kobako on 2017/3/1.
 * Just a game
 */
public class Re0SpiderTest {
    Re0Spider spider;
    @Before
    public void init(){
        spider = new Re0Spider();
    }

    @Test
    public void testHttpGetPage(){
        String url = "http://tieba.baidu.com/p/4605372404";
        String outputPath = "C:\\Users\\zhuo\\Desktop\\15in4.txt";
        Path path = Paths.get(outputPath);
        int startPage = 1;
        int endPage = 5;
        String content = spider.getNeed(url,startPage,endPage);
        try {
            Files.write(path,content.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
