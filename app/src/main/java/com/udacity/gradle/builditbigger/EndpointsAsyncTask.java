package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<String, Void, String> {

    private static MyApi myApiService = null;

    @Override
    protected String doInBackground(String... params) {


        if (myApiService == null) {  // Only do this once


            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 192.168.1.6 is localhost's IP address in Android enmulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://192.168.1.6:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

}
