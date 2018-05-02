package com.example.umairpanwar.url_json_parsing;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    String json1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new JsonDownloaderTask().execute();
        TextView tv2 = findViewById(R.id.mainTextView);



    }
     private class JsonDownloaderTask extends AsyncTask<Void,Void,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            if (s!=null){
                TextView tv2 = findViewById(R.id.mainTextView);

                try {
                    JSONObject jo = new JSONObject(s);
                    Integer userid = jo.getInt("userId");
                    Integer id = jo.getInt("id");
                    String tittle = jo.getString("title");
                    String body = jo.getString("body");
                    Json_Dm json_dm = new Json_Dm(userid,id,tittle,body);
                    tv2.setText(String.valueOf(json_dm.getBody()+"   "+json_dm.getTittle()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {

                URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line=bufferedReader.readLine())!=null){
                    stringBuilder.append(line);
                }
                String json = stringBuilder.toString();
                urlConnection.disconnect();
                stringBuilder.delete(0,json.length());


                Log.d("MYINT", "value: " + json);
             //   json=json1;

                return json;


            }catch (IOException ex){
                ex.printStackTrace();
            }

            return null;
        }
    }
}
