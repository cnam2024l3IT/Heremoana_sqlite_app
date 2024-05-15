package com.example.darkmode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btnAdd;
    Button btnListAnnonces;
    TextView tv;
    EditText etTitle;
    EditText etPrice;
    EditText etDescription;
    EditText etDatePublication;
    EditText etDateFinPublication;
    private AnnoncesDatabaseHelper dbHandler;
    Context currentContent;
    private SharedPreferences Settings;

    Annonces annonce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnAdd = findViewById(R.id.bt_add);
        btnListAnnonces = findViewById(R.id.bt_listAnnonces);
        etTitle = findViewById(R.id.et_title);
        etPrice = findViewById(R.id.et_price);
        etDescription = findViewById(R.id.et_description);
        etDatePublication = findViewById(R.id.et_datePublication);
        etDateFinPublication = findViewById(R.id.et_dateFinPublication);

        dbHandler = new AnnoncesDatabaseHelper(MainActivity.this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                annonce = new Annonces(etTitle.getText().toString(), etPrice.getText().length(), etDescription.getText().toString(), etDatePublication.getText().toString(), etDateFinPublication.getText().toString());

                // validating if the text fields are empty or not.
                if (annonce.getTitle().isEmpty() || annonce.getPrice()==0 || annonce.getDescription().isEmpty() || annonce.getDatePublication().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Les champs sont vide..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewAnnonce(annonce);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "L'annonce a été ajoutée.", Toast.LENGTH_SHORT).show();
                etTitle.setText("");
                etPrice.setText("");
                etDescription.setText("");
                etDatePublication.setText("");
                etDateFinPublication.setText("");
            }
        });

        btnListAnnonces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(currentContent, ListAnnoncesActivity.class);
                startActivity(intent);
            }
        });




        Settings = getSharedPreferences("DarkMode", Context.MODE_PRIVATE);
        boolean isChecked = Settings.getBoolean("switch", false);
        float textSize = Settings.getInt("textSize", 16);

        currentContent = this;
        btn = findViewById(R.id.button);
        tv = findViewById(R.id.tv_id);

        if (isChecked){
            tv.setText("DarkMode");
            tv.setTextSize(textSize);
        }else {
            tv.setText("LightMode");
            tv.setTextSize(textSize);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(currentContent, SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}