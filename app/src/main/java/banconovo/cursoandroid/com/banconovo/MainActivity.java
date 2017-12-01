package banconovo.cursoandroid.com.banconovo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText agencia;
    private EditText conta;
    private Button cadastrar;
    private TextView nomeCadastrado;
    private TextView agenciaCadastrada;
    private TextView contaCadastrada;
    private Button acessarConta;

    private static final String ARQUIVO_BANCO = "AquivoBanco";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (EditText) findViewById(R.id.campoNomeId);
        agencia = (EditText) findViewById(R.id.campoAgenciaId);
        conta = (EditText) findViewById(R.id.campoContaId);
        cadastrar = (Button) findViewById(R.id.button);
        nomeCadastrado = (TextView) findViewById(R.id.nomeCadastradoId);
        agenciaCadastrada = (TextView) findViewById(R.id.agenciaCadastradaId);
        contaCadastrada = (TextView) findViewById(R.id.contaCadastradaId);
        acessarConta = (Button) findViewById(R.id.button2);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_BANCO, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(nome.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Por favor, preencher o nome.", Toast.LENGTH_LONG).show();
                }else{
                    editor.putString("nome", nome.getText().toString() );
                    editor.commit();
                    nomeCadastrado.setText("Cliente: "+ nome.getText().toString() );
                }
                if (agencia.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Por favor, preencher a agencia.", Toast.LENGTH_LONG).show();
                }else {
                    editor.putString("agencia", agencia.getText().toString() );
                    editor.commit();
                    agenciaCadastrada.setText("Agência: " + agencia.getText().toString() );
                }
                if (conta.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Por favor, preencher a conta.", Toast.LENGTH_LONG).show();
                }else {
                    editor.putString("conta", conta.getText().toString() );
                    editor.commit();
                    contaCadastrada.setText("Conta: " + conta.getText().toString() );
                }
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_BANCO, 0);
        if (sharedPreferences.contains("nome") ){
            String nomeCliente = sharedPreferences.getString("nome", "Cliente não definido");
            nomeCadastrado.setText("Cliente:" + nomeCliente);
        }else{
            nomeCadastrado.setText("");
        }
        if (sharedPreferences.contains("agencia") ){
            String agenciaCliente = sharedPreferences.getString("agencia", "Agencia não definida");
            agenciaCadastrada.setText("Ag:" + agenciaCliente);
        }else {
            agenciaCadastrada.setText("");
        }
        if (sharedPreferences.contains("conta") ){
            String contaCliente = sharedPreferences.getString("conta", "conta não definida");
            contaCadastrada.setText("Con:" + contaCliente);
        }else {
            contaCadastrada.setText("");
        }
        acessarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SaldoActivity.class));
            }
        });

    }
}
