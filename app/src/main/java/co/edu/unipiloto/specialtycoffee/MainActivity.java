package co.edu.unipiloto.specialtycoffee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button drinksButton = findViewById(R.id.drinksButton);
        Button methodsButton = findViewById(R.id.methodsButton);
        Button storesButton = findViewById(R.id.storesButton);

        drinksButton.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, BebidasActivity.class);
            startActivity(intent);

        });

        methodsButton.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, MetodosActivity.class);
            startActivity(intent);

        });

        storesButton.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, SucursalesActivity.class);
            startActivity(intent);

        });

    }

}