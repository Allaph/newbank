package banconovo.cursoandroid.com.banconovo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SaldoActivity extends AppCompatActivity {
    private TextView campoSaldo;
    private Button verificarSaldo;
    private Button telaSaque;
    private Button telaDeposito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saldo);
        campoSaldo = (TextView) findViewById(R.id.campoSaldoId);
        verificarSaldo = (Button) findViewById(R.id.verificarSaldoId);
        telaDeposito = (Button) findViewById(R.id.depositoTelaId);
        telaSaque = (Button) findViewById(R.id.saqueTelaID);

        final Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        final String txt = bundle.getString("txt");
        final String txt2 = bundle.getString("txt2");


        //txtResultado.setText(txt);

        verificarSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (campoSaldo = null){
                    campoSaldo.setText("SALDO INDISPONIVEL");
                }else{

                }

            }
        });
        telaDeposito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SaldoActivity.this, DepositoActivity.class));
            }
        });
        telaSaque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SaldoActivity.this, SaqueActivity.class));
            }
        });


    }
}
