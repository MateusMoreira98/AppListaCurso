package devandroid.moreira.applistavip.View;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

import devandroid.moreira.applistavip.Model.Pessoa;
import devandroid.moreira.applistavip.R;
import devandroid.moreira.applistavip.controller.CursoController;
import devandroid.moreira.applistavip.controller.PessoaController;

public class  MainActivity extends AppCompatActivity {
    CursoController cursocontroller;
     List<String> nomeDoCurso;
     PessoaController controller;
     Pessoa pessoa;
     EditText editPrimeiroNome;
     EditText editSobrenome;
     EditText editCursoDesejado;
     EditText editTelefonedeContato;
     Button btnlimpar;
     Button btnsalvar;
     Button btnFinalizar;

     Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        controller = new PessoaController(MainActivity.this);
        pessoa = new Pessoa();
        controller.buscar(pessoa);
        cursocontroller = new CursoController();
        nomeDoCurso = cursocontroller.dadosParaSpinner();

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

        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        cursocontroller.dadosParaSpinner();
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

         btnlimpar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 editPrimeiroNome.setText("");
                 editSobrenome.setText("");
                 editCursoDesejado.setText("");
                 editTelefonedeContato.setText("");
                 controller.limpar_dados();

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
