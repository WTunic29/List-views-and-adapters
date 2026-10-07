package co.edu.unipiloto.specialtycoffee;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BebidasActivity extends AppCompatActivity {

    private ListView drinksListView;
    private DatabaseHelper databaseHelper;
    private ArrayList<String> bebidas;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        drinksListView = findViewById(R.id.drinksListView);
        Button addDrinkButton = findViewById(R.id.addDrinkButton);
        Button queryDrinkButton = findViewById(R.id.queryDrinkButton);

        databaseHelper = new DatabaseHelper(this);
        bebidas = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bebidas);

        drinksListView.setAdapter(adapter);

        drinksListView.setOnItemClickListener((parent, view, position, id) -> {

                    String bebidaSeleccionada = bebidas.get(position);

                    Intent intent = new Intent(BebidasActivity.this, DetalleBebidaActivity.class);
                    intent.putExtra("bebida", bebidaSeleccionada);

                    startActivity(intent);
                }
        );

        addDrinkButton.setOnClickListener(v -> {

            Intent intent = new Intent(BebidasActivity.this, AgregarBebidasActivity.class);
            startActivity(intent);

        });

        queryDrinkButton.setOnClickListener(v -> {

            cargarBebidas();
            adapter.notifyDataSetChanged();

            Toast.makeText(this, "Bebidas consultadas desde SQLite", Toast.LENGTH_SHORT).show();

        });

    }

    private void cargarBebidas() {

        bebidas.clear();

        Cursor cursor = databaseHelper.obtenerBebidas();

        if (cursor.moveToFirst()) {

            do {
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                bebidas.add(nombre);

            } while (cursor.moveToNext());

        }

        cursor.close();
    }

}