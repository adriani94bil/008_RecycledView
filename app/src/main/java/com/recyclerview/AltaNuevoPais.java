package com.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AltaNuevoPais extends AppCompatActivity {

    private Button btnGrabar;
    private EditText ediTextNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_nuevo_pais);

        this.btnGrabar=findViewById(R.id.botonGrabar);
        this.ediTextNombre=findViewById(R.id.editTextNombre);
    }
    public void grabar(View view){
        Intent returnIntent=new Intent();
        returnIntent.putExtra("nombre",
                this.ediTextNombre.getText().toString());

        setResult(RESULT_OK,returnIntent);
        finish();
    }
}