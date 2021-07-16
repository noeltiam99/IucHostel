package com.btech.IucHostel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class bills extends AppCompatActivity {
    private final int ID_HOME = 1;
    private final int ID_SETTINGS = 2;
    private final int ID_LOGOUT = 3;
    private Button electricityBillButton, waterBillButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);
        waterBillButton = findViewById(R.id.waterBillButton);
        electricityBillButton = findViewById(R.id.electricityBillButton);
        TextView selected_page =findViewById(R.id.selected_page);
        MeowBottomNavigation bottomNavigation = findViewById(R.id.btnNavigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME,R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_SETTINGS,R.drawable.ic_setting2));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_LOGOUT,R.drawable.ic_logout));

        waterBillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(bills.this, "Water Bills Are Included In Your Rent", Toast.LENGTH_LONG).show();
            }
        });

        electricityBillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bills.this, electricity.class);
                startActivity(intent);
            }
        });

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item){
                Toast.makeText(bills.this, "clicked item:" + item.getId(), Toast.LENGTH_SHORT).show();
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
    }
}