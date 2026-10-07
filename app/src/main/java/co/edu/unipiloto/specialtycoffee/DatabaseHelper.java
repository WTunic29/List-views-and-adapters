package co.edu.unipiloto.specialtycoffee;

import android.content.ContentValues;
import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.database.Cursor;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "specialtycoffee.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createBebidasTable = "CREATE TABLE bebidas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL, " +
                "descripcion TEXT, " +
                "metodo TEXT, " +
                "perfil TEXT, " +
                "cuerpo TEXT)";

        db.execSQL(createBebidasTable);

        insertarBebidasIniciales(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS bebidas");
        onCreate(db);

    }

    // Insertar una bebida
    public long insertarBebida(String nombre, String descripcion,
            String metodo, String perfil, String cuerpo) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nombre", nombre);
        values.put("descripcion", descripcion);
        values.put("metodo", metodo);
        values.put("perfil", perfil);
        values.put("cuerpo", cuerpo);

        return db.insert("bebidas", null, values);

    }

    public Cursor obtenerBebidas() {

        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery(
                "SELECT * FROM bebidas",
                null);
    }

    public Cursor obtenerBebidaPorNombre(String nombre) {

        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery(
                "SELECT * FROM bebidas WHERE nombre = ?",
                new String[]{nombre});
    }

    private void insertarBebidasIniciales(SQLiteDatabase db) {

        ContentValues values = new ContentValues();

        values.put("nombre", "Espresso");
        values.put("descripcion", "Café concentrado de sabor intenso");
        values.put("metodo", "Máquina espresso");
        values.put("perfil", "Intenso y achocolatado");
        values.put("cuerpo", "Alto");

        db.insert("bebidas", null, values);
        values.clear();

        values.put("nombre", "Cappuccino");
        values.put("descripcion", "Espresso combinado con leche vaporizada");
        values.put("metodo", "Máquina espresso");
        values.put("perfil", "Dulce y cremoso");
        values.put("cuerpo", "Medio");

        db.insert("bebidas", null, values);
        values.clear();

        values.put("nombre", "V60");
        values.put("descripcion", "Café filtrado de extracción manual");
        values.put("metodo", "V60");
        values.put("perfil", "Floral y frutal");
        values.put("cuerpo", "Ligero");

        db.insert("bebidas", null, values);
        values.clear();

        values.put("nombre", "Aeropress");
        values.put("descripcion", "Café preparado mediante presión e inmersión");
        values.put("metodo", "Aeropress");
        values.put("perfil", "Dulce y balanceado");
        values.put("cuerpo", "Medio");

        db.insert("bebidas", null, values);
        values.clear();

        values.put("nombre", "Cold Brew");
        values.put("descripcion", "Café extraído en frío durante varias horas");
        values.put("metodo", "Extracción en frío");
        values.put("perfil", "Dulce y refrescante");
        values.put("cuerpo", "Medio");

        db.insert("bebidas", null, values);

    }

}