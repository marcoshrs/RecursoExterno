package com.example.aluno.recursoexterno;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by aluno on 15/06/18.
 */

public class BuscarTimesWS extends AsyncTask<String, Integer, String> {
    Activity activity;
    public BuscarTimesWS(Activity activity){
        this.activity = activity;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        TextView textView = (TextView) activity.findViewById(R.id.textViewTimes);
        Gson gson = new Gson();
        List<Time> listaTimes = gson.fromJson(s, new TypeToken<List<Time>>(){}.getType());

        for(Time t:listaTimes){
            textView.setText(textView.getText()+" ; "+t.getNome());
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        String jsonRetorno = null;
        try{
            URL url = new URL(strings[0]);
            InputStream stream = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();
            String linha;
            while((linha = bufferedReader.readLine())!= null){
                builder.append(linha);
            }
            jsonRetorno = builder.toString();
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }


        return jsonRetorno;
    }
}
