package com.example.mohamedabdelaziz.jokeapp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.mohamedabdelaziz.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by Mohamed Abd Elaziz on 8/5/2017.
 */
class EndpointAsyncTask extends AsyncTask<Context, Void, String> {
     MyApi api = null;
     Context context;

    @Override
    protected String doInBackground(Context... params) {
        if (api == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new
                    AndroidJsonFactory(), null)
                    .setRootUrl("https://android­app­backend.appspot.com/_ah/api/");
            api = builder.build();
        }
        context = params[0];
        try {
            return api.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}