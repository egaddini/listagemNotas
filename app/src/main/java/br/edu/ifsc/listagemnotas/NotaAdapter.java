package br.edu.ifsc.listagemnotas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import br.edu.ifsc.listagemnotas.modelo.Nota;

public class NotaAdapter extends ArrayAdapter<Nota> {

    private Context mContext;
    private int mResource;

    public NotaAdapter(Context context, int resource, ArrayList<Nota> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView tvId = (TextView) convertView.findViewById(R.id.tvId);
        TextView tvTitulo = (TextView) convertView.findViewById(R.id.tvTitulo);

        Nota nota = getItem(position);
        tvId.setText(Integer.toString(nota.getId()));
        tvTitulo.setText(nota.getTitulo());
        return convertView;
    }

}
