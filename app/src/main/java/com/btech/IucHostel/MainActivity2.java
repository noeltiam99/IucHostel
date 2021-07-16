package com.btech.IucHostel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity2 extends AppCompatActivity {

    CardView cardPersonal;
    CardView cardBill;
    CardView cardReport;
    CardView cardNews;

    private final int ID_HOME = 1;
    private final int ID_SETTINGS = 2;
    private final int ID_LOGOUT = 3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // getSupportActionBar().hide();

        TextView selected_page =findViewById(R.id.selected_page);
        MeowBottomNavigation bottomNavigation = findViewById(R.id.btnNavigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME,R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_SETTINGS,R.drawable.ic_setting2));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_LOGOUT,R.drawable.ic_logout));

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item){
                Toast.makeText(MainActivity2.this, "clicked item:" + item.getId(), Toast.LENGTH_SHORT).show();
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

       bottomNavigation.show(ID_HOME, true);

        cardPersonal = findViewById(R.id.cardPersonal);
        cardBill = findViewById(R.id.cardBill);
        cardReport = findViewById(R.id.cardReport);
        cardNews = findViewById(R.id.cardNews);

        cardPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 showToast("Personal Information selected");
            }
        });
        cardBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Bills selected");
            }
        });
        cardReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Report a problem selected");
            }
        });
        cardNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("News selected");
            }
        });
    }

    private void showToast(String message){

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public void nextSteppers(View view) {
        Intent intent = new Intent(MainActivity2.this, PersonalInfo.class);
        startActivity(intent);
    }
    public void nextbill(View view) {
        Intent intent = new Intent(MainActivity2.this, bills.class);
        startActivity(intent);
    }
    public void nextreport(View view) {
        Intent intent = new Intent(MainActivity2.this, report.class);
        startActivity(intent);
    }
    public void nextnein(View view) {
        Intent intent = new Intent(MainActivity2.this, report.class);
        startActivity(intent);
    }

}