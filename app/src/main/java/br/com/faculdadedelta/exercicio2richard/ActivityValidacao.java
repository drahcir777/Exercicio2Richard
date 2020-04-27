package br.com.faculdadedelta.exercicio2richard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityValidacao extends AppCompatActivity {

    public static final int RESULT_CODE_SUCCESS = 1;
    public static final int RESULT_CODE_ERROR = 0;
    private String nome, preco, cor, modelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validacao);

        Intent intent = getIntent();
        if(intent != null){

            nome = intent.getStringExtra("nomeParam");
            preco = intent.getStringExtra("precoParam");
            cor = intent.getStringExtra("corParam");
            modelo = intent.getStringExtra("modeloParam");

            TextView tvNome = findViewById(R.id.tvNome);
            tvNome.setText("Nome: " + nome);

            TextView tvValor = findViewById(R.id.tvValor);
            tvValor.setText("Valor: " + preco);

            TextView tvCor = findViewById(R.id.tvCor);
            tvCor.setText("Cor: " + cor);

            TextView tvModelo = findViewById(R.id.tvModelo);
            tvModelo.setText("Modelo: " + modelo);
        }
    }
    public void validar(View view){

        String resposta = "";
        double valorMin = 1000;
        Double valorConv = Double.parseDouble(preco);

        if(nomeAprovado() && valorConv > valorMin){
            resposta = "Validado com sucesso!";
        }else if (valorConv < valorMin){
            resposta = "Valor Invalido! O valor deve ser maior que 1000";
        }else if (nomeAprovado() == false){
            resposta = "Nome Invalido! O numero de caracteres deve ser maior que 30";
        }
        Intent data = new Intent();
        data.putExtra("resposta", resposta);

        setResult(RESULT_CODE_SUCCESS, data);
        finish();
    }
    public boolean nomeAprovado(){return nome.length() > 30;}
}

