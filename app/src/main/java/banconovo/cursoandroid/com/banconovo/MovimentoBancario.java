package banconovo.cursoandroid.com.banconovo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MovimentoBancario extends AppCompatActivity {
    private EditText telaDeposito;
    private EditText telaSaque;
    private Button finalizarTransacao;
    private TextView saldoFinal;

    private static final String ARQUIVO_SALDO = "arquivoSaldo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimento_bancario);
        telaDeposito = (EditText) findViewById(R.id.telaDepositoId);
        telaSaque = (EditText) findViewById(R.id.telaSaqueId);
        finalizarTransacao = (Button) findViewById(R.id.finalizarTransacaoId);
        saldoFinal = (TextView) findViewById(R.id.saldoFinalId);

        finalizarTransacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_SALDO, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                String deposito = telaDeposito.getText().toString();
                String saque = telaSaque.getText().toString();

                if (deposito.isEmpty()) {
                    Toast.makeText(MovimentoBancario.this, "Insira um valor.", Toast.LENGTH_LONG).show();
                } else if (saque.isEmpty()) {
                    Toast.makeText(MovimentoBancario.this, "Insira um valor.", Toast.LENGTH_LONG).show();
                }

                int valorDeposito = Integer.parseInt(deposito);
                int valorSaque = Integer.parseInt(saque);

                int valorTotal = valorDeposito - valorSaque;

                if(valorTotal == 0){
                    Toast.makeText(MovimentoBancario.this, "Saldo vazio.", Toast.LENGTH_LONG).show();
                }else{
                    editor.putString("saldo", String.valueOf(valorTotal));
                    editor.commit();
                    saldoFinal.setText(" "+ valorTotal + ",00" );
                }
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_SALDO, 0);
        if (sharedPreferences.contains("saldo") ){
            String nomeCliente = sharedPreferences.getString("saldo", "Saldo indisponivel");
            saldoFinal.setText(" " + nomeCliente + ",00");
        }else{
            saldoFinal.setText("");
        }
    }
}
