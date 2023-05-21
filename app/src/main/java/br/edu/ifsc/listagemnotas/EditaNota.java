package br.edu.ifsc.listagemnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifsc.listagemnotas.controlador.NotaControlador;
import br.edu.ifsc.listagemnotas.modelo.Nota;

public class EditaNota extends AppCompatActivity {

    private NotaControlador notaControlador;
    private EditText edTitulo, edTexto;
    private TextView tvId;
    private Nota nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_nota);
        Bundle bundle  = getIntent().getExtras();
        notaControlador = new NotaControlador(getApplicationContext());
        edTitulo = findViewById(R.id.edTitulo2);
        edTexto = findViewById(R.id.edTexto2);
        tvId = findViewById(R.id.id);
        Integer id = bundle.getInt("id");
        nota = notaControlador.buscarNotaPorId(id);
        edTitulo.setText(nota.getTitulo());
        edTexto.setText(nota.getTexto());
        tvId.setText(id.toString());
    }

    public void editaNota(View view) {
        Boolean n = notaControlador.atualizaNota(nota);
        Toast.makeText(this, "Nota Atualizada", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void deletaNota(View view) {
        notaControlador.excluiNota(nota);
        Toast.makeText(this, "Nota Excluida", Toast.LENGTH_SHORT).show();
        finish();
    }

}