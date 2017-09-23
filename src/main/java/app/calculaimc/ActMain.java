package app.calculaimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActMain extends AppCompatActivity {

    private EditText edtAltura, edtPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        edtAltura = (EditText) findViewById(R.id.edtAltura);
        edtPeso = (EditText) findViewById(R.id.edtPeso);
    }

    public void eventBtnCalcular(View v){

        if(!edtAltura.getText().toString().isEmpty() && !edtPeso.getText().toString().isEmpty()){

            try{
                double peso = Double.parseDouble(edtPeso.getText().toString());
                double altura = Double.parseDouble(edtAltura.getText().toString());

                Intent tela = new Intent(this, ActShowIMC.class);
                tela.putExtra("imc", (peso / (altura * altura)));
                startActivity(tela);
            }catch (Exception e){

                Toast.makeText(this,"Verifique os dados digitados",Toast.LENGTH_SHORT);
            }
        }
    }

}
