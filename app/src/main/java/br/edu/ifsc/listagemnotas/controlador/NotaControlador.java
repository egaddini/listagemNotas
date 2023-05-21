package br.edu.ifsc.listagemnotas.controlador;

import android.content.Context;
import android.database.Cursor;

import java.sql.Array;
import java.util.ArrayList;

import br.edu.ifsc.listagemnotas.modelo.Nota;
import br.edu.ifsc.listagemnotas.modelo.NotaDAO;

public class NotaControlador {

    private Context mContext;
    private NotaDAO notaDAO;

    public NotaControlador(Context context) {
        mContext = context;
        notaDAO = new NotaDAO(context);
    }

    public Nota cadastrarNota(Nota n) {
        return notaDAO.inserirNota(n);
    }

    public ArrayList<Nota> listaNotas() {
        return notaDAO.getListaNotas();
    }

    public ArrayList<String> listaTituloNotas() {
        ArrayList<String> result = new ArrayList<String>();
        for (Nota nota: this.listaNotas()) {
            result.add(nota.getTitulo());
        }
        return result;
    }

    public Boolean excluiNota(Nota n) {
        return notaDAO.excluiNota(n);
    }

    public Boolean atualizaNota(Nota n) {
        return notaDAO.atualizaNota(n);
    }

    public Nota buscarNotaPorId(int id) {
        return notaDAO.buscarNotaPorId(id);
    }

}
