package com.kobako.re0;

import com.kobako.SpiderUtil;
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
        spider = new Re0Spider.Builder().minTextLength(0).build();
    }

    @Test
    public void testHttpGetPage(){
        String url = "https://tieba.baidu.com/p/4950684707";
        String outputPath = "C:\\Users\\zhuo\\Desktop\\testIt.txt";
        int startPage = 1;
        int endPage = 1;
        String content = spider.getNeed(url,startPage,endPage);
        try {
            SpiderUtil.writeOutToPath(content,outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
