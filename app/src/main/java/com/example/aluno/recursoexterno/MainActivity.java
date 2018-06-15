package com.example.aluno.recursoexterno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buscarImagem(View view){
        BuscarImagem buscarImagem = new BuscarImagem(this);
        buscarImagem.execute("https://i.ndtvimg.com/i/2017-08/ola-cabs-google_827x510_61503392022.jpg");
    }
}
