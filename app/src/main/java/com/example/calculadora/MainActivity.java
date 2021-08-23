package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text_respuesta;

    private Button btn_suma;
    private Button btn_resta;
    private Button btn_multiplicacion;
    private Button btn_division;
    private Button btn_potencia;
    private Button btn_raiz;
    private Button btn_sin;
    private Button btn_cos;
    private Button btn_igual;

    private EditText edit_valor1;

    private String  operador;

    private Double reserva;

    private Switch swt_funciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_respuesta = findViewById(R.id.respuesta);

        edit_valor1 = findViewById(R.id.valor1);

        btn_suma = findViewById(R.id.btn_suma);
        btn_suma.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick (View v){
                reserva = Double.parseDouble(edit_valor1.getText().toString());
                operador = "+";
                edit_valor1.setText("");
        }
    });

        btn_resta = findViewById(R.id.btn_resta);
        btn_resta.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick (View v){
                reserva = Double.parseDouble(edit_valor1.getText().toString());
                operador = "-";
                edit_valor1.setText("");
            }
        });

        btn_multiplicacion = findViewById(R.id.btn_multiplicacion);
        btn_multiplicacion.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick (View v){
                reserva = Double.parseDouble(edit_valor1.getText().toString());
                operador = "*";
                edit_valor1.setText("");
            }
        });

        btn_division = findViewById(R.id.btn_division);
        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                reserva = Double.parseDouble(edit_valor1.getText().toString());
                operador = "/";
                edit_valor1.setText("");
            }
        });

        btn_potencia = findViewById(R.id.btn_potencia);
        btn_potencia.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick (View v){
                text_respuesta.setText(potencia(Double.parseDouble(edit_valor1.getText().toString())) + "");
                edit_valor1.setText(potencia(Double.parseDouble(edit_valor1.getText().toString())) + "");
            }
        });

        btn_raiz = findViewById(R.id.btn_raiz);
        btn_raiz.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick (View v){
                text_respuesta.setText(raiz(Double.parseDouble(edit_valor1.getText().toString())) + "");
                edit_valor1.setText(raiz(Double.parseDouble(edit_valor1.getText().toString())) + "");
            }
        });

        btn_sin = findViewById(R.id.btn_seno);
        btn_sin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick (View v){
                text_respuesta.setText(seno(Double.parseDouble(edit_valor1.getText().toString()))+"");
            }
        });

        btn_cos = findViewById(R.id.btn_coseno);
        btn_cos.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick (View v){
                text_respuesta.setText(coseno(Double.parseDouble(edit_valor1.getText().toString()))+"");
            }
        });

        btn_igual = findViewById(R.id.btn_igual);
        btn_igual.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick (View v){
                if (operador.equals("+")){
                    text_respuesta.setText(suma(reserva, Double.parseDouble(edit_valor1.getText().toString())) + "");
                    edit_valor1.setText(suma(reserva, Double.parseDouble(edit_valor1.getText().toString())) + "");
                }
                if (operador.equals("-")){
                    text_respuesta.setText(resta(reserva, Double.parseDouble(edit_valor1.getText().toString()))+"");
                    edit_valor1.setText(resta(reserva, Double.parseDouble(edit_valor1.getText().toString()))+"");
                }
                if (operador.equals("*")){
                    text_respuesta.setText(multp(reserva, Double.parseDouble(edit_valor1.getText().toString()))+"");
                    edit_valor1.setText(multp(reserva, Double.parseDouble(edit_valor1.getText().toString()))+"");
                }
                if (operador.equals("/")){
                    text_respuesta.setText(div(reserva, Double.parseDouble(edit_valor1.getText().toString()))+"");
                    edit_valor1.setText(div(reserva, Double.parseDouble(edit_valor1.getText().toString()))+"");
                }
            }
        });

    }

    public double suma (double x, double y){
        return x + y;
    }

    public double resta (double x, double y){
        return x - y;
    }

    public double multp (double x, double y){
        return x * y;
    }

    public String div (double x, double y){
        if (y==0){
            return "Error";
        }
        return String.valueOf(x/y);
    }

    public double potencia (double x){
        return Math.pow(x,2);
    }

    public double raiz (double x){
        return Math.sqrt(x);
    }

    public double seno (double x){
        Double rad=Math.toRadians(x);
        return Math.sin(rad);
    }

    public double coseno (double x){
        Double rad=Math.toRadians(x);
        return Math.cos(rad);
    }

}