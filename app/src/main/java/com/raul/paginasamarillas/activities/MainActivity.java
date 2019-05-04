package com.raul.paginasamarillas.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.raul.paginasamarillas.R;

public class MainActivity extends AppCompatActivity {
    private EditText editext_search;
    private Button buttonsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editext_search = findViewById(R.id.text_search);
        buttonsearch = findViewById(R.id.button_search);

        buttonsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });
    }

    private void search(){
        String category = editext_search.getText().toString().trim();

        if(!category.isEmpty()) {
            Intent intent = new Intent(this, ResultSearchActivity.class);

            intent.putExtra("category", category);
            startActivity(intent);
        }else {
            Toast.makeText(this,"Ingrese una categoria", Toast.LENGTH_SHORT).show();
        }
    }
}
