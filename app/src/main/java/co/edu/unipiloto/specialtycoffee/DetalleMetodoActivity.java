package co.edu.unipiloto.specialtycoffee;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleMetodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalle_metodo);

        TextView methodNameTextView = findViewById(R.id.methodNameTextView);
        String metodoSeleccionado = getIntent().getStringExtra("metodo");

        if (metodoSeleccionado != null) {
            methodNameTextView.setText(metodoSeleccionado);
        }

    }

}