package co.edu.unipiloto.specialtycoffee;

import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleSucursalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_sucursal);

        TextView storeNameTextView = findViewById(R.id.storeNameTextView);
        String sucursalSeleccionada = getIntent().getStringExtra("sucursal");

        if (sucursalSeleccionada != null) {
            storeNameTextView.setText(sucursalSeleccionada);
        }

    }

}