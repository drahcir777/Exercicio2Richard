package br.com.faculdadedelta.exercicio2richard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int CODIGO_RETORNO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar(View view){

        EditText etNome = findViewById(R.id.tvNome);
        EditText etPreco = findViewById(R.id.tvValor);
        EditText etCor = findViewById(R.id.tvCor);
        EditText etModelo = findViewById(R.id.tvModelo);

        Intent intent = new Intent(getBaseContext(), ActivityValidacao.class);
        String nomeParam = etNome.getText().toString();
        String precoParam = etPreco.getText().toString();
        String corParam = etCor.getText().toString();
        String modeloParam =etModelo.getText().toString();

        if(nomeParam.isEmpty()){
            Toast.makeText(getBaseContext(),"O campo nome é obrigatório!",
                    Toast.LENGTH_LONG).show();
        }else if (precoParam.isEmpty()){
            Toast.makeText(getBaseContext(), "O campo valor é obrigatório!",
                    Toast.LENGTH_LONG).show();
        }else if (corParam.isEmpty()){
            Toast.makeText(getBaseContext(), "O campo cor é obrigatório!",
                    Toast.LENGTH_LONG).show();
        }else if (modeloParam.isEmpty()){
            Toast.makeText(getBaseContext(), "O campo modelo é obrigatório!",
                    Toast.LENGTH_LONG).show();
        }else {

            intent.putExtra("nomeParam", nomeParam);
            intent.putExtra("precoParam", precoParam);
            intent.putExtra("corParam", corParam);
            intent.putExtra("modeloParam", modeloParam);

            startActivityForResult(intent, CODIGO_RETORNO );
        }
    }

    public void limparCampos(View view){

        EditText etNome = findViewById(R.id.tvNome);
        EditText etPreco = findViewById(R.id.tvValor);
        EditText etPeso = findViewById(R.id.tvCor);
        EditText etAltura = findViewById(R.id.tvModelo);

        etNome.setText("");
        etPreco.setText("");
        etPeso.setText("");
        etAltura.setText("");

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODIGO_RETORNO){
            if (resultCode == ActivityValidacao.RESULT_CODE_SUCCESS) {
                String retorno = data.getStringExtra("resposta");
                Toast.makeText(getBaseContext(), retorno, Toast.LENGTH_LONG).show();
            }
        }
    }
}
