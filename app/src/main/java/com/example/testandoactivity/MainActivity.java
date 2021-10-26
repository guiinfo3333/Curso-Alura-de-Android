package com.example.testandoactivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.testandoactivity.dao.AlunoDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    public static final String LISTA_DE_ALUNOS = "Lista de alunos";
    private final AlunoDao dao = new AlunoDao();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(LISTA_DE_ALUNOS);
        configuraNovoAluno();
    }

    private void configuraNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.ttttt);
        botaoNovoAluno.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormularioActivity();
            }
        });
    }


    private void abreFormularioActivity(){
        startActivity( new Intent(MainActivity.this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.listatop);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));
    }
}