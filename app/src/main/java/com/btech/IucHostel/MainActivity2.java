package com.btech.IucHostel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.btech.IucHostel.Database.Entities.Localuser;
import com.btech.IucHostel.Database.IUCDatabase;
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
        cardPersonal = findViewById(R.id.cardPersonal);
        cardBill = findViewById(R.id.cardBill);
        cardReport = findViewById(R.id.cardReport);
        cardNews = findViewById(R.id.cardNews);
        // getSupportActionBar().hide();

        TextView selected_page = findViewById(R.id.selected_page);
        MeowBottomNavigation bottomNavigation = findViewById(R.id.btnNavigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_SETTINGS, R.drawable.ic_setting2));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_LOGOUT, R.drawable.ic_logout));

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                switch (item.getId()) {

                    case ID_SETTINGS:{
                        Intent intent = new Intent(MainActivity2.this, settings.class);
                        startActivity(intent);
                    }
                        break;
                    case ID_LOGOUT:{
                        logOut(MainActivity2.this);
                    }
                        break;
                    default:{
                        Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
                        startActivity(intent);
                    }
                }
//                Toast.makeText(MainActivity2.this, "clicked item:" + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                String name;
//                switch (item.getId()) {
//                    case ID_HOME:
//                        name = "Home";
//                        break;
//                    case ID_SETTINGS:
//                        name = "settings";
//                        break;
//                    case ID_LOGOUT:
//                        name = "logout";
//                        break;
//                    default:
//                        name = "Account";
//                }
//                selected_page.setText(getString(R.string.main_page_selected));
            }
        });

        bottomNavigation.show(ID_HOME, true);


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

    private void showToast(String message) {

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
        Intent intent = new Intent(MainActivity2.this, nein.class);
        startActivity(intent);
    }

    public static void logOut(Context context){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        // Setting Alert Dialog Title
        alertDialogBuilder.setTitle("Confirm LogOut..!!!");
        // Icon Of Alert Dialog
//        alertDialogBuilder.setIcon(R.drawable.question);
        // Setting Alert Dialog Message
        alertDialogBuilder.setMessage("Are you sure,You want to logout?");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Localuser localuser = IUCDatabase.getInstance(context).localUserDao().getAll().get(0);
                IUCDatabase.getInstance(context).localUserDao().delete(localuser);
                Intent intent = new Intent(context, login.class);
                context.startActivity(intent);
                ((Activity)context).finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity2.this,"You clicked over No",Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getApplicationContext(),"You clicked on Cancel",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}