package co.edu.unipiloto.specialtycoffee;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class MetodosActivity extends AppCompatActivity {

    private ListView methodsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_metodos);

        methodsListView = findViewById(R.id.methodsListView);

        String[] metodos = {
                "V60",
                "Aeropress",
                "Prensa Francesa",
                "Chemex",
                "Espresso"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, metodos);

        methodsListView.setAdapter(adapter);

        methodsListView.setOnItemClickListener(

                (parent, view, position, id) -> {

                    String metodoSeleccionado = metodos[position];

                    Intent intent = new Intent(MetodosActivity.this, DetalleMetodoActivity.class);
                    intent.putExtra("metodo", metodoSeleccionado);

                    startActivity(intent);

                }

        );

    }

}