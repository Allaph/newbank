package banconovo.cursoandroid.com.banconovo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SaqueActivity extends AppCompatActivity {
    private EditText valorSaque;
    private Button confirmarSaque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saque);
        valorSaque = (EditText) findViewById(R.id.valorSaqueId);
        confirmarSaque = (Button) findViewById(R.id.confirmarSaqueId);

        confirmarSaque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String saqueTela = valorSaque.getText().toString();
                Intent intent = new Intent(SaqueActivity.this, SaldoActivity.class);
                String txt2;
                txt2 = valorSaque.getText().toString();
                Bundle bundle = new Bundle();

                bundle.putString("txt2", txt2);
                intent.putExtras(bundle);

            }
        });

    }
}
