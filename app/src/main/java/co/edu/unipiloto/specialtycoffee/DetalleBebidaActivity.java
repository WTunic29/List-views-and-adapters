package co.edu.unipiloto.specialtycoffee;

import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetalleBebidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalle_bebida);

        TextView drinkNameTextView = findViewById(R.id.drinkNameTextView);
        String bebidaSeleccionada = getIntent().getStringExtra("bebida");

        if (bebidaSeleccionada != null) {
            drinkNameTextView.setText(bebidaSeleccionada);
        }

    }

}