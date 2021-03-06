package br.com.mariojp.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OutraActivity extends AppCompatActivity {

    private EditText editTextUserName;
    private Button confirmar;
    private Button cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);

        editTextUserName = findViewById(R.id.editTextUserName);
        confirmar = findViewById(R.id.btnConfirmar);
        cancelar = findViewById(R.id.btnCancelar);

        Intent intent = getIntent();
        final String usuarioLogado = intent.getStringExtra("usuarioLogado");
        editTextUserName.setText(usuarioLogado);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextUserName.getText().toString();
                if(name.equals("")) {
                    Intent it = new Intent(OutraActivity.this, MainActivity.class);
                    it.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    it.putExtra("mensagem", "");
                    startActivity(it);
                }else {
                    Intent it = new Intent(OutraActivity.this, MainActivity.class);
                    it.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    it.putExtra("mensagem", editTextUserName.getText().toString());
                    startActivity(it);
                }
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(OutraActivity.this, MainActivity.class);
                it.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                it.putExtra("mensagem", usuarioLogado);
                startActivity(it);
            }
        });
    }
}
