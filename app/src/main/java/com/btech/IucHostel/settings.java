package com.btech.IucHostel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class settings extends AppCompatActivity {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    private final int ID_HOME = 1;
    private final int ID_SETTINGS = 2;
    private final int ID_LOGOUT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView selected_page =findViewById(R.id.selected_page);
        MeowBottomNavigation bottomNavigation = findViewById(R.id.btnNavigation);

        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME,R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_SETTINGS,R.drawable.ic_setting2));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_LOGOUT,R.drawable.ic_logout));
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item){
                switch (item.getId()) {

                    case ID_SETTINGS:{
                        Intent intent = new Intent(settings.this, settings.class);
                        startActivity(intent);
                    }
                    break;
                    case ID_LOGOUT:{
                        MainActivity2.logOut(settings.this);
                    }
                    break;
                    default:{
                        Intent intent = new Intent(settings.this, MainActivity2.class);
                        startActivity(intent);
                    }
                }
//                Toast.makeText(settings.this, "clicked item:" + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                String name;
                switch (item.getId()){

                    case ID_HOME: name ="Home";
                        break;
                    case ID_SETTINGS: name ="settings";
                        break;
                    case ID_LOGOUT: name ="logout";
                        break;
                    default: name ="Account";
                }
                selected_page.setText(getString(R.string.main_page_selected));
            }
        });
        bottomNavigation.show(ID_SETTINGS, true);
    }

}