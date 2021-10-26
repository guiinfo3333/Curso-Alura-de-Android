package com.example.testandoactivity.dao;
import com.example.testandoactivity.models.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {

    private final static List<Aluno> alunos = new ArrayList<Aluno>();

    public void salvar( Aluno alunoCriado ) {
        alunos.add(alunoCriado);
    }


    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
