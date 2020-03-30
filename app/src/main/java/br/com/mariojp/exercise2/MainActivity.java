package br.com.mariojp.exercise2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String usuarioAtual = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState!=null) {
            this.usuarioAtual = savedInstanceState.getString("nomeAtual");
        } else {
            this.usuarioAtual = new String();
        }

        TextView textoPrimeiraTela = findViewById(R.id.textView);
        textoPrimeiraTela.setText("Oi");

        Intent outraIntent = getIntent();
        String nomeNovo = outraIntent.getStringExtra("novoNome");
        usuarioAtual = nomeNovo;

        if (nomeNovo == null || nomeNovo.equals("")) {
            textoPrimeiraTela.setText(textoPrimeiraTela.getText().toString() + "!");
        }else{
            textoPrimeiraTela.setText(textoPrimeiraTela.getText().toString() +", "+ nomeNovo + "!");
        }
    }

    public void clickTrocarUsuario(View view){
        Intent intent = new Intent(MainActivity.this, OutraActivity.class);
        intent.putExtra("atual", usuarioAtual);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("nomeAtual", usuarioAtual);
    }
//
//    @Override
//    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onRestoreInstanceState(savedInstanceState, persistentState);
//    }

}
