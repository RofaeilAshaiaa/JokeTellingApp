package com.udacity.gradle.builditbigger;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


@SmallTest
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Test
    public void testAsyncTaskEndpoints(){

        final String joke = "this is a funny joke!";

        EndpointsAsyncTask task = new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                assertEquals(joke,result);
            }
        };

        task.execute();

    }

}