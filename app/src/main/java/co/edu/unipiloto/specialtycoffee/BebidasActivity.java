package co.edu.unipiloto.specialtycoffee;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;


public class BebidasActivity extends AppCompatActivity {
    private ListView drinksListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        drinksListView = findViewById(R.id.drinksListView);

        String[] bebidas = {
                "Espresso",
                "Cappuccino",
                "V60",
                "Aeropress",
                "Cold Brew"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, bebidas);

        drinksListView.setAdapter(adapter);

        drinksListView.setOnItemClickListener((parent, view, position, id) -> {

            String bebidaSeleccionada = bebidas[position];
            Intent intent = new Intent(BebidasActivity.this, DetalleBebidaActivity.class);

            intent.putExtra("bebida", bebidaSeleccionada);

            startActivity(intent);

        });
    }

}