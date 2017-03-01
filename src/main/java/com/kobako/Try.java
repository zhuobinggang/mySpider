package com.kobako;

import com.kobako.re0.Re0Spider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by kobako on 2017/3/1.
 * Just a game
 */
public class Try {
    public static void main(String[] args) {
        String source = Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(1)+"/source.txt";
        String content = "";
        try {
            List<String> list = Files.readAllLines(Paths.get(source));
            StringBuilder sb = new StringBuilder();
            list.forEach(sb::append);
            content = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Re0Spider spider = new Re0Spider();
    }
}
