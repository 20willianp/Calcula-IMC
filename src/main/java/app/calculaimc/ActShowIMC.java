package app.calculaimc;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActShowIMC extends AppCompatActivity {
    private TextView txtIMC, txtSituacao;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_show_imc);

        txtIMC = (TextView) findViewById(R.id.txtIMC);
        txtSituacao = (TextView) findViewById(R.id.txtSituacao);

        Bundle parametro = getIntent().getExtras();
        if(parametro.containsKey("imc")){

            txtIMC.setText(new DecimalFormat("0.##").format(parametro.getDouble("imc")));
            txtSituacao.setText(verificaSituacao(parametro.getDouble("imc")));
        }
    }

    public void eventBtnVoltar(View v){
        startActivity(new Intent(this,ActMain.class));
    }

    /*
    Abaixo de 17 	Muito abaixo do peso
    Entre 17 e 18,49 	Abaixo do peso
    Entre 18,5 e 24,99 	Peso normal
    Entre 25 e 29,99 	Acima do peso
    Entre 30 e 34,99 	Obesidade I
    Entre 35 e 39,99 	Obesidade II (severa)
    Acima de 40 	Obesidade III (mórbida)
    */
    private String verificaSituacao(double imc){
        if(imc < 17){
            return "Muito abaixo do peso";
        }else if(imc >= 17 && imc <= 18.49){
            return "Abaixo do peso";
        }else if(imc >= 18.5 && imc <= 24.99){
            return "Peso normal";
        }else if(imc >= 25 && imc <= 29.99){
            return "Acima do peso";
        }else if(imc >= 30 && imc <= 34.99){
            return "Obesidade I";
        }else if(imc >= 35 && imc <= 39.99){
            return "Obesidade II (severa)";
        }else{
            return "Obesidade III (mórbida)";
        }
    }
}
