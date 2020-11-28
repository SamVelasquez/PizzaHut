package com.example.pizzahut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Menu_act extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);
        videoView = (VideoView) findViewById(R.id.videoView);

        // colocamos la ruta en donde se encuentra el video
        String ruta = "android.resource://"+ getPackageName()+"/"+R.raw.video ;
        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);

        // controles de navegacion
        MediaController media=  new MediaController(this);
        videoView.setMediaController(media);

    }

    public void gestioncliente (View view){
        Intent clientes = new Intent(this, Firebase_act.class);
        startActivity(clientes);
    }
    public  void promociones (View view){
        Intent promociones = new Intent(this,Promociones_act.class);
        startActivity(promociones);
    }
}