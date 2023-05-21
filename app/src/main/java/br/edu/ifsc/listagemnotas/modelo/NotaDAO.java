package br.edu.ifsc.listagemnotas.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDAO {

    private SQLiteDatabase sqLiteDatabase;

    public NotaDAO(Context context) {
        sqLiteDatabase = context.openOrCreateDatabase("dbNotas", context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo VARCHAR," +
                "texto VARCHAR);");
    }

    public Nota inserirNota(Nota n) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", n.getTitulo());
        contentValues.put("texto", n.getTexto());
        int i = (int) sqLiteDatabase.insert("notas", null, contentValues);
        n.setId(i);
        return n;
    }

    public ArrayList<Nota> getListaNotas() {
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM notas;", null);
        cursor.moveToFirst();
        ArrayList<Nota> arrayList = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            arrayList.add(new Nota(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)));
            cursor.moveToNext();
        }
        return arrayList;
    }

    public Boolean excluiNota(Nota n) {
        String[] whereArgs = {String.valueOf(n.getId())};
        sqLiteDatabase.delete("notas", "id = ?", whereArgs);
        return true;
    }

    public Boolean atualizaNota(Nota n) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", n.getTitulo());
        contentValues.put("texto", n.getTexto());
        String[] whereArgs = {String.valueOf(n.getId())};
        sqLiteDatabase.update("notas", contentValues, "id = ?", whereArgs);
        return true;
    }

    public Nota buscarNotaPorId(int id) {
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM notas WHERE id = ?;", new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()) {
            String titulo = cursor.getString(1);
            String texto = cursor.getString(2);
            return new Nota(id, titulo, texto);
        }
        return null;
    }



}
