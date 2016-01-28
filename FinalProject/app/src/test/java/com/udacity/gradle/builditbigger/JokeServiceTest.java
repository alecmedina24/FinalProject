package com.udacity.gradle.builditbigger;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by alecmedina on 1/26/16.
 */
public class JokeServiceTest {
    private String[] jokes;

    @Test
    public void fetchJokeTest() {
        final CountDownLatch signal = new CountDownLatch(1);
        JokeService jokeService = new JokeService(new JokeService.CallBack() {
            @Override
            public void setJokes(String[] jokes) {
                JokeServiceTest.this.jokes = jokes;
                signal.countDown();
            }
        });
        jokeService.getJokes();
        try {
            signal.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(jokes);
    }
}
