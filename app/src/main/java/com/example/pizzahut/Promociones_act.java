package com.example.pizzahut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import calculos.Promociones;

public class Promociones_act extends AppCompatActivity {

    private Spinner spinner2, spinner3;
    private EditText valorenvio;
    private Button calculopromocion;
    private TextView textView3, texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        valorenvio=(EditText)findViewById(R.id.valorenvio);
        calculopromocion = (Button)findViewById(R.id.calculopromocion);
        textView3 = (TextView)findViewById(R.id.textView3);
        texto = (TextView)findViewById(R.id.texto);

        //spinner 2

        String [] NombresClientes = {"Ramiro", "Rosa", "Robert"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NombresClientes);
        spinner2.setAdapter(adapter);// asocio el spinner2 con el array

        //spinner3
        String [] NombresPromociones = {"Pizza Promo", "Master Pizza", "Pizza Max"};
        ArrayAdapter<String> adapte = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, NombresPromociones);
        spinner3.setAdapter(adapte);// asocio el spinner3 con el array



        calculopromocion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombres = spinner2.getSelectedItem().toString();
                String promo = spinner3.getSelectedItem().toString();

                Promociones promociones = new Promociones(); // importo la clase

                //pizzapromo
                if (promo.equals("Pizza Promo")&& nombres.equals("Ramiro")){

                    int entero = Integer.parseInt(valorenvio.getText().toString());

                    int a = entero + promociones.getPizzapromo();

                    String resultado = String.valueOf(a);

                    textView3.setText("Estimado mario el final segun promocion y envio es: ");
                    texto.setText("$ " + resultado);
                }
                if (promo.equals("Pizza Promo")&& nombres.equals("Rosa")){

                    int entero = Integer.parseInt(valorenvio.getText().toString());

                    int a = entero + promociones.getPizzapromo();

                    String resultado = String.valueOf(a);

                    textView3.setText("Estimado mario el final segun promocion y envio es: ");
                    texto.setText("$ " + resultado);
                }
                if (promo.equals("Pizza Promo")&& nombres.equals("Robert")){

                    int entero = Integer.parseInt(valorenvio.getText().toString());

                    int a = entero + promociones.getPizzapromo();

                    String resultado = String.valueOf(a);

                    textView3.setText("Estimado mario el final segun promocion y envio es: ");
                    texto.setText("$ " + resultado);
                }
                //master pizza
                if (promo.equals("Master Pizza")&& nombres.equals("Ramiro")){

                    int entero = Integer.parseInt(valorenvio.getText().toString());

                    int a = entero + promociones.getMasterpizza();

                    String resultado = String.valueOf(a);

                    textView3.setText("Estimado mario el final segun promocion y envio es: ");
                    texto.setText("$ " + resultado);
                }
                if (promo.equals("Master Pizza")&& nombres.equals("Robert")) {

                    int entero = Integer.parseInt(valorenvio.getText().toString());

                    int a = entero + promociones.getMasterpizza();

                    String resultado = String.valueOf(a);

                    textView3.setText("Estimado mario el final segun promocion y envio es: ");
                    texto.setText("$ " + resultado);
                }
                if (promo.equals("Master Pizza")&& nombres.equals("Rosa")) {

                    int entero = Integer.parseInt(valorenvio.getText().toString());

                    int a = entero + promociones.getMasterpizza();

                    String resultado = String.valueOf(a);

                    textView3.setText("Estimado mario el final segun promocion y envio es: ");
                    texto.setText("$ " + resultado);
                }
                //maxpizza
                if (promo.equals("Pizza Max")&& nombres.equals("Ramiro")){

                    int entero = Integer.parseInt(valorenvio.getText().toString());

                    int a = entero + promociones.getPizzaMax();

                    String resultado = String.valueOf(a);

                    textView3.setText("Estimado mario el final segun promocion y envio es: ");
                    texto.setText("$ " + resultado);
                }
                if (promo.equals("Pizza Max")&& nombres.equals("Robert")) {

                    int entero = Integer.parseInt(valorenvio.getText().toString());

                    int a = entero + promociones.getPizzaMax();

                    String resultado = String.valueOf(a);

                    textView3.setText("Estimado mario el final segun promocion y envio es: ");
                    texto.setText("$ " + resultado);
                }
                if (promo.equals("Pizza Max")&& nombres.equals("Rosa")) {

                    int entero = Integer.parseInt(valorenvio.getText().toString());

                    int a = entero + promociones.getPizzaMax();

                    String resultado = String.valueOf(a);

                    textView3.setText("Estimado mario el final segun promocion y envio es: ");
                    texto.setText("$ " + resultado);
            }   }
        });
    }

}