package devandroid.moreira.applistavip.controller;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import devandroid.moreira.applistavip.Model.Pessoa;
import devandroid.moreira.applistavip.View.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "Pref_AppListaVip";


    public PessoaController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        listaVip = preferences.edit();

    }

    public void salvar(Pessoa pessoa) {
        Log.d("MVC_CONTROLLER", " DADOS SALVOS " + pessoa.toString());

        listaVip.putString("primeiro nome ", pessoa.getPrimeiroNome());
        listaVip.putString("sobrenome ", pessoa.getSobreNome());
        listaVip.putString("curso desejado ", pessoa.getCursoDesejado());
        listaVip.putString("telefone ", pessoa.getTelefoneContato());
        listaVip.apply();
    }

    public Pessoa buscar (Pessoa pessoa) {

         pessoa.setPrimeiroNome(preferences.getString("primeiro nome ","NA"));
         pessoa.setSobreNome(preferences.getString("sobrenome ","NA"));
         pessoa.setTelefoneContato(preferences.getString("telefone ", "NA"));
         pessoa.setCursoDesejado(preferences.getString("curso desejado ","NA"));
      return pessoa;
    }

    public void limpar_dados() {

        listaVip.clear();
        listaVip.apply();
    }





}
