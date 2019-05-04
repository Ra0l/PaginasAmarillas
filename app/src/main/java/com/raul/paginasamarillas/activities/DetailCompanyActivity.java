package com.raul.paginasamarillas.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.raul.paginasamarillas.R;
import com.raul.paginasamarillas.models.Company;
import com.raul.paginasamarillas.repositories.CompanyRepository;

public class DetailCompanyActivity extends AppCompatActivity {
    private static final int CALL_PERMISSION_REQUEST=100;
    private Integer id;

    private ImageView pictureImage;
    private TextView category;
    private TextView name;
    private TextView address;
    private TextView phone;
    private TextView email;
    private TextView webtext;
    private TextView info;

    private Intent intent;
    private Company company;

    private Button button_call;
    private Button button_web;
    private Button button_share;
    private Button button_message;
    private Button button_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_company);

        pictureImage = findViewById(R.id.picture_image);
        category = findViewById(R.id.category_text);
        name = findViewById(R.id.name_text_input);
        address = findViewById(R.id.direccion_text_input);
        phone = findViewById(R.id.phone_text_input);
        email = findViewById(R.id.email_text_input);
        webtext = findViewById(R.id.url_text_input);
        info = findViewById(R.id.info_text_input);

        this.id=getIntent().getExtras().getInt("id");

        Company company = CompanyRepository.getCompanyById(id);

        if(company !=null){
            int resouceid = getResources().getIdentifier(company.getPicture(),"drawable",getPackageName());

            pictureImage.setImageResource(resouceid);
            category.setText(company.getCategory());
            name.setText(company.getName());
            address.setText(company.getAddress());
            phone.setText(company.getPhone());
            email.setText(company.getEmail());
            webtext.setText(company.getUrl());
            info.setText(company.getInfo());
        }

        button_call = findViewById(R.id.mobilphone_implicito);

        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamarcontacto();
            }
        });

        button_web = findViewById(R.id.web_implicito);
        button_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar();
            }
        });

        button_share = findViewById(R.id.share_implicito);
        button_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });

        button_message=findViewById(R.id.message_implicito);
        button_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message();
            }
        });

        button_email = findViewById(R.id.email_implicito);
        button_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email();
            }
        });

    }

    private void email(){
        String email_text = email.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, email_text);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    private void message(){
        String number_message = phone.getText().toString();

        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setType("vnd.android-dir/mms-sms");
        intent.putExtra("address", number_message);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }

    }

    private void share(){

        String information= info.getText().toString();
        String nameshare = name.getText().toString();
        String direction = address.getText().toString();
        String cellphone = phone.getText().toString();
        String webpage = webtext.getText().toString();
        String emailtext = email.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,
                "Name : "+nameshare+
                        " Direction : "+direction+
                        " Phone : "+cellphone+
                        " Page Web : "+webpage +
                        " Email : " +emailtext+
                        " Information : "+information);

        startActivity(intent);
    }

    private void buscar(){

        String url=webtext.getText().toString();


        if(url.startsWith("http://")|| !url.startsWith("https://")){
            url = "http://" + url;
        }

        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }

    }



    private void llamarcontacto(){
        //Verificar si tengo permiso

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, CALL_PERMISSION_REQUEST);
            return;
        }

        String phonenumber=phone.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel: "+ phonenumber));

        startActivity(intent);
    }
}
