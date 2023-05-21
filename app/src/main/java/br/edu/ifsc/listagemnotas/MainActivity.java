package br.edu.ifsc.listagemnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.edu.ifsc.listagemnotas.controlador.NotaControlador;
import br.edu.ifsc.listagemnotas.modelo.Nota;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
    }

    public void novaNota(View view) {
        Intent intent = new Intent(this, ExibirNota.class);
        intent.putExtra("id_nota", 0);
        startActivity(intent);
    }

    public void editaNota(View view, Integer id) {
        Intent intent = new Intent(this, EditaNota.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        NotaControlador notaControlador = new NotaControlador(this);
        ArrayList<Nota> dados = notaControlador.listaNotas();
        NotaAdapter adapter = new NotaAdapter(this, R.layout.nota_personalizada, dados);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Nota nota = dados.get(i);
                editaNota(view, nota.getId());
            }

        });
    }
}