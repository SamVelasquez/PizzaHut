package com.example.pizzahut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.FirebaseApp;

import java.util.UUID;

import listado.listadoClientes;

public class Firebase_act extends AppCompatActivity {
    private Button listaclientesguardados , guardar ;

    private EditText nombrecliente, destinocliente,tipopromo;

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);
        nombrecliente= (EditText)findViewById(R.id.nombrecliente);
        destinocliente =(EditText)findViewById(R.id.destinocliente);
        listaclientesguardados = (Button)findViewById(R.id.listaclientesguardados);
        guardar = (Button)findViewById(R.id.guardar);
        tipopromo = (EditText)findViewById(R.id.tipopromo);


        //manejamos el button de listado
        listaclientesguardados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Listadoclientes_act.class);
                startActivity(i);
            }
        });






        // desde aqui parte la base de datos

        inicializarBase();
        // añadir campos
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!nombrecliente.getText().equals("")){
                    //
                        listadoClientes n = new listadoClientes();
                        n.setId(UUID.randomUUID().toString());
                        n.setNombre(nombrecliente.getText().toString());
                        n.setDestino(destinocliente.getText().toString());
                        n.setTipopromo(tipopromo.getText().toString());

                        databaseReference.child("listadoClientes").child(n.getId()).setValue(n);

                    Toast.makeText(getBaseContext(),"Guardo exitosamente.",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getBaseContext(),"debe rellenar el campo.",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void inicializarBase(){
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }


}