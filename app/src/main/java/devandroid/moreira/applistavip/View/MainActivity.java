package devandroid.moreira.applistavip.View;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import devandroid.moreira.applistavip.Model.Pessoa;
import devandroid.moreira.applistavip.R;
import devandroid.moreira.applistavip.controller.PessoaController;

public class  MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "Pref_AppListaVip";
    PessoaController controller;
     Pessoa pessoa;
     EditText editPrimeiroNome;
     EditText editSobrenome;
     EditText editCursoDesejado;
     EditText editTelefonedeContato;
     Button btnlimpar;
     Button btnsalvar;
     Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES,0);
        listaVip = preferences.edit();

        controller = new PessoaController();
        pessoa = new Pessoa();

        pessoa.setPrimeiroNome(preferences.getString("primeiro nome ",""));
        pessoa.setSobreNome(preferences.getString("sobrenome ",""));
        pessoa.setTelefoneContato(preferences.getString("telefone ", ""));
        pessoa.setCursoDesejado(preferences.getString("curso desejado ",""));

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editCursoDesejado.setText(pessoa.getCursoDesejado());
        editTelefonedeContato.setText(pessoa.getTelefoneContato());





        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCursoDesejado = findViewById(R.id.editCursoDesejado);
        editTelefonedeContato = findViewById(R.id.editTelefonedeContato);

        btnlimpar = findViewById(R.id.btnlimpar);
        btnsalvar = findViewById(R.id.btnsalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

         btnlimpar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 editPrimeiroNome.setText("");
                 editSobrenome.setText("");
                 editCursoDesejado.setText("");
                 editTelefonedeContato.setText("");

                 listaVip.clear();
                 listaVip.apply();

             }
         });
         btnsalvar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 editPrimeiroNome.setText(pessoa.getPrimeiroNome().toString());
                 editSobrenome.setText(pessoa.getSobreNome().toString());
                 editCursoDesejado.setText(pessoa.getCursoDesejado().toString());
                 editTelefonedeContato.setText(pessoa.getTelefoneContato().toString());
                 Toast.makeText(MainActivity.this,"Dados Salvos "+pessoa.toString(),Toast.LENGTH_LONG).show();

                 listaVip.putString("primeiro nome ", pessoa.getPrimeiroNome());
                 listaVip.putString("sobrenome ", pessoa.getSobreNome());
                 listaVip.putString("curso desejado ", pessoa.getCursoDesejado());
                 listaVip.putString("telefone ", pessoa.getTelefoneContato());
                 listaVip.apply();

                 controller.salvar(pessoa);
             }
         });
         btnFinalizar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(MainActivity.this,"Finalizado",Toast.LENGTH_LONG).show();
                 finish();
             }
         });
    }
}