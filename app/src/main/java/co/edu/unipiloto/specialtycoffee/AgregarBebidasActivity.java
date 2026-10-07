package co.edu.unipiloto.specialtycoffee;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AgregarBebidasActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText descriptionEditText;
    private EditText methodEditText;
    private EditText profileEditText;
    private EditText bodyEditText;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_agregar_bebidas);

        nameEditText = findViewById(R.id.nameEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        methodEditText = findViewById(R.id.methodEditText);
        profileEditText = findViewById(R.id.profileEditText);
        bodyEditText = findViewById(R.id.bodyEditText);

        Button saveButton = findViewById(R.id.saveButton);

        databaseHelper = new DatabaseHelper(this);

        saveButton.setOnClickListener(v -> guardarBebida());
    }

    private void guardarBebida() {

        String nombre = nameEditText.getText().toString().trim();
        String descripcion = descriptionEditText.getText().toString().trim();
        String metodo = methodEditText.getText().toString().trim();
        String perfil = profileEditText.getText().toString().trim();
        String cuerpo = bodyEditText.getText().toString().trim();

        if (nombre.isEmpty()) {
            Toast.makeText(this, "Ingrese el nombre de la bebida", Toast.LENGTH_SHORT).show();
            return;
        }

        long resultado = databaseHelper.insertarBebida(nombre, descripcion, metodo, perfil, cuerpo);

        if (resultado != -1) {

            Toast.makeText(this, "Bebida guardada correctamente", Toast.LENGTH_SHORT).show();
            finish();

        } else {

            Toast.makeText(this, "Error al guardar la bebida", Toast.LENGTH_SHORT).show();
        }

    }

}