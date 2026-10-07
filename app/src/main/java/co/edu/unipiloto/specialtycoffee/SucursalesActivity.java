package co.edu.unipiloto.specialtycoffee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SucursalesActivity extends AppCompatActivity {

    private ListView storesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sucursales);

        storesListView = findViewById(R.id.storesListView);

        String[] sucursales = {
                "Centro",
                "Chapinero",
                "Teusaquillo",
                "Usaquén",
                "La Candelaria"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                sucursales
        );

        storesListView.setAdapter(adapter);

        storesListView.setOnItemClickListener(
                (parent, view, position, id) -> {

                    String sucursalSeleccionada =
                            sucursales[position];

                    Intent intent = new Intent(
                            SucursalesActivity.this,
                            DetalleSucursalActivity.class
                    );

                    intent.putExtra(
                            "sucursal",
                            sucursalSeleccionada
                    );

                    startActivity(intent);
                }
        );
    }
}