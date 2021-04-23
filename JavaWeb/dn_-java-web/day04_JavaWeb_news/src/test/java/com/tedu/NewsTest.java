package com.tedu;

import com.tedu.servies.NewsServiesImpl;
import org.junit.Test;

public class NewsTest {

    @Test
    public void getAllCount() {

        NewsServiesImpl newsServies = new NewsServiesImpl();
        System.out.println(newsServies.getAllCount());

    }
}
