package com.raul.paginasamarillas.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.raul.paginasamarillas.R;
import com.raul.paginasamarillas.adapters.CompanyAdapter;
import com.raul.paginasamarillas.models.Company;
import com.raul.paginasamarillas.repositories.CompanyRepository;

import java.util.List;

public class ResultSearchActivity extends AppCompatActivity {

    private TextView resultText;
    private RecyclerView recyclerView;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_search);

        resultText = findViewById(R.id.text_view);
        recyclerView = findViewById(R.id.company_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.category = getIntent().getExtras().getString("category");
        List<Company> companys = CompanyRepository.filterCompaniesByCategory(category);


        CompanyAdapter adapter = new CompanyAdapter(this);
        adapter.setCompanys(companys);

        int count = adapter.getItemCount();
        if(count == 0){
            resultText.setText("No se encontraron para la categoria: " + category);
        }else {
            resultText.setText("Encontrados para categoria: " + category);
            recyclerView.setAdapter(adapter);
        }
    }
}
