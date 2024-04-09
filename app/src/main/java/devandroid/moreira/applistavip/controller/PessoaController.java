package devandroid.moreira.applistavip.controller;

import android.util.Log;

import devandroid.moreira.applistavip.Model.Pessoa;

public class PessoaController {

    public void salvar(Pessoa pessoa) {
        Log.d("MVC_CONTROLLER", " DADOS SALVOS " + pessoa.toString());
    }
}
