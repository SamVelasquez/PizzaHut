package com.example.pizzahut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import listado.listadoClientes;

public class Listadoclientes_act extends AppCompatActivity {
    private ListView list;

    private ArrayList<listadoClientes>listadoClientes = new ArrayList<listadoClientes>();
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    listadoClientes listadoClientesSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listadoclientes_act);
        list = (ListView)findViewById(R.id.list);


        incializarbase();
        databaseReference.child("listadoClientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot objSnapshot : snapshot.getChildren()){

                listadoClientes n= objSnapshot.getValue(listadoClientes.class);
                listadoClientes.add(n);

                    ArrayAdapter adapter= new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1,listadoClientes);
                    list.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {
                listadoClientesSelected = (listadoClientes) parent.getItemAtPosition(position);
            }
        });


    }

    public void eliminar (View v){
        listadoClientes n = new listadoClientes();
        n.setId(listadoClientesSelected.getId());
        databaseReference.child("listadoClientes").child(n.getId()).removeValue();
        Toast.makeText(getBaseContext(),"Elemento Eliminado.",Toast.LENGTH_LONG).show();


    }
    public  void  incializarbase(){
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();

    }


}