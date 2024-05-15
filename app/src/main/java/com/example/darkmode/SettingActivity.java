package com.example.darkmode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    Button btn;
    Context currentContent;
    private SharedPreferences prefs;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    SharedPreferences Settings;
    SharedPreferences.Editor e;
    Switch sw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        currentContent = this;

        Toast mytoast = new Toast(currentContent);
        mytoast.setDuration(Toast.LENGTH_SHORT);


        btn = findViewById(R.id.button2);
        sw = findViewById(R.id.s_id);

        rb1 = findViewById(R.id.rb_1);
        rb2 = findViewById(R.id.rb_2);
        rb3 = findViewById(R.id.rb_3);

        Settings = getSharedPreferences("DarkMode", Context.MODE_PRIVATE);
        boolean isChecked = Settings.getBoolean("switch", false);
        float textSize = Settings.getInt("textSize", 16);

        if(isChecked){
            sw.setChecked(true);
        }else{
            sw.setChecked(false);
        }

        if(textSize == 16){
            rb1.setChecked(true);
        }else if(textSize == 32){
            rb2.setChecked(true);
        }else {
            rb3.setChecked(true);
        }

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings = getSharedPreferences("DarkMode", Context.MODE_PRIVATE);

                e = Settings.edit();
                e.putBoolean("switch", sw.isChecked());
                e.commit();

                if (sw.isChecked() == true){
                    mytoast.setText("DarMode est activé");
                }else {
                    mytoast.setText("DarMode est désactivé");
                }
                mytoast.show();
            }

        });

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Settings = getSharedPreferences("DarkMode", Context.MODE_PRIVATE);
                e = Settings.edit();
                e.putInt("textSize", 16);
                e.commit();
                mytoast.setText("La taille du texte est de 16");
                mytoast.show();
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Settings = getSharedPreferences("DarkMode", Context.MODE_PRIVATE);
                e = Settings.edit();
                e.putInt("textSize", 32);
                e.commit();

                mytoast.setText("La taille du texte est de 32");
                mytoast.show();
            }
        });

        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Settings = getSharedPreferences("DarkMode", Context.MODE_PRIVATE);
                e = Settings.edit();
                e.putInt("textSize", 64);
                e.commit();
                mytoast.setText("La taille du texte est de 64");
                mytoast.show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(currentContent, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}