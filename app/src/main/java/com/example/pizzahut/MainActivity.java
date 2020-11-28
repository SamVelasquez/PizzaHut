package com.example.pizzahut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
// declaro variables
    private Button ingresar ;
    private ProgressBar progressBar;
    private EditText usario, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ingresar = (Button)findViewById(R.id.ingresar);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        usario = (EditText)findViewById(R.id.usario);
        password = (EditText)findViewById(R.id.password);

        // para controlar el botton
        ingresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                String nombre=usario.getText().toString();
                String pass = password.getText().toString();
                if(nombre.equalsIgnoreCase("android") && pass.equals("123")) {

                    new Task().execute(); // ejecuta mi tarea asíncrona.
                }
                else{
                    Toast.makeText(getApplicationContext(),"Datos incorrectos",Toast.LENGTH_SHORT).show();
                }
            }
        });

        progressBar.setVisibility(View.INVISIBLE); // desaparece el elemento para que no se vea antes de iniicar la
    }

    class Task extends AsyncTask<String, Void, String> {

        @Override  // Vamos a darle la configuración inicial a la tarea
        protected void onPreExecute() {

            progressBar.setVisibility(View.VISIBLE);
        }


        @Override // vamos a emplear el proceso o tarea pesada en segundo plano.
        protected String doInBackground(String... strings) {


            for(int i = 1; i < 10; i++)
            {
                try {
                    Thread.sleep(1000);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override // finalizamos la tarea
        protected void onPostExecute(String s) {

            progressBar.setVisibility(View.INVISIBLE);

            Intent i = new Intent(getBaseContext(), Menu_act.class);
            startActivity(i);

        }
    }

}