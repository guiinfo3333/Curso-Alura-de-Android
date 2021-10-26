package com.example.testandoactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testandoactivity.dao.AlunoDao;
import com.example.testandoactivity.models.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String LISTA_DE_ALUNOS = "Lista de alunos";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    AlunoDao dao = new AlunoDao();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicializaView();
        inicializacaoCampos();
        configuraBotaoSalvar();
    }

    private void inicializaView() {
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(LISTA_DE_ALUNOS);
    }


    private void configuraBotaoSalvar() {
        Button botaosalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        botaosalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CriaAluno();
                finish();
            }
        });
    }

    private void inicializacaoCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void CriaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();
        Aluno alunocriado = new Aluno(nome, telefone, email);
        dao.salvar(alunocriado);
    }
}