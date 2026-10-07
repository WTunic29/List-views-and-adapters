package co.edu.unipiloto.specialtycoffee;

import android.database.Cursor;

import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleBebidaActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalle_bebida);

        TextView drinkNameTextView = findViewById(R.id.drinkNameTextView);
        TextView drinkDescriptionTextView = findViewById(R.id.drinkDescriptionTextView);
        TextView drinkMethodTextView = findViewById(R.id.drinkMethodTextView);
        TextView drinkProfileTextView = findViewById(R.id.drinkProfileTextView);
        TextView drinkBodyTextView = findViewById(R.id.drinkBodyTextView);

        databaseHelper = new DatabaseHelper(this);

        String bebidaSeleccionada = getIntent().getStringExtra("bebida");

        if (bebidaSeleccionada != null) {
            Cursor cursor = databaseHelper.obtenerBebidaPorNombre(bebidaSeleccionada);

            if (cursor.moveToFirst()) {

                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                String descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion"));
                String metodo = cursor.getString(cursor.getColumnIndexOrThrow("metodo"));
                String perfil = cursor.getString(cursor.getColumnIndexOrThrow("perfil"));
                String cuerpo = cursor.getString(cursor.getColumnIndexOrThrow("cuerpo"));

                drinkNameTextView.setText(nombre);

                drinkDescriptionTextView.setText("Descripción: " + descripcion);
                drinkMethodTextView.setText("Método: " + metodo);
                drinkProfileTextView.setText("Perfil: " + perfil);
                drinkBodyTextView.setText("Cuerpo: " + cuerpo);

            }

            cursor.close();
        }

    }

}