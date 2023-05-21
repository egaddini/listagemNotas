package br.edu.ifsc.listagemnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsc.listagemnotas.controlador.NotaControlador;
import br.edu.ifsc.listagemnotas.modelo.Nota;

public class ExibirNota extends AppCompatActivity {

    private NotaControlador notaControlador;
    private EditText titulo, texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_nota);
        notaControlador = new NotaControlador(getApplicationContext());
        titulo = findViewById(R.id.titulo);
        texto = findViewById(R.id.texto);
    }

    public void salvarNota(View view) {
        Nota n = notaControlador.cadastrarNota(new Nota(titulo.getText().toString(), texto.getText().toString()));
        Toast.makeText(this, Integer.toString(n.getId()), Toast.LENGTH_SHORT).show();
    }



}