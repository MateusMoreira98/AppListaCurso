package devandroid.moreira.applistavip.controller;


import java.util.ArrayList;
import java.util.List;

import devandroid.moreira.applistavip.Model.curso;

public class CursoController {

    private List listCursos;

    public List getListaDeCursos() {
        listCursos = new ArrayList<curso>();
        listCursos.add("Java");
        listCursos.add("HTML");
        listCursos.add("C#");
        listCursos.add("C++");
        listCursos.add("Pytho");
        listCursos.add("PHP");
        listCursos.add("Javascript");
        return listCursos;
    }
    public ArrayList<String> dadosParaSpinner () {

        ArrayList<String> dados = new ArrayList<>();
         for (int i = 0; i < getListaDeCursos().size(); i++) {
             curso onjeto = (curso) getListaDeCursos().get(i);
             dados.add(onjeto.getCursoDesejado());
         }
         return dados;
    }
}

