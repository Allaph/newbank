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

public class DepositoActivity extends AppCompatActivity {
   // private EditText efetuarDeposito;
    private Button confirmarDeposito;

    private static final String ARQUIVO_DEPOSITO = "arquivoDeposito";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposito);
       // efetuarDeposito = (EditText) findViewById(R.id.valorDepositoId);
        confirmarDeposito = (Button) findViewById(R.id.confirmarDepositoId);


        confirmarDeposito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DepositoActivity.this, SaldoActivity.class);
                TextView efetuarDeposito = (TextView) findViewById(R.id.valorDepositoId);
                //String depositoTela = efetuarDeposito.getText().toString();
                String txt;
                txt = efetuarDeposito.getText().toString();
                Bundle bundle = new Bundle();

                bundle.putString("txt", txt);
                intent.putExtras(bundle);

                //startActivity(intent);

            }
        });
    }
}
