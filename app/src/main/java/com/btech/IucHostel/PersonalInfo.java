package com.btech.IucHostel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.btech.IucHostel.Database.IUCDatabase;
import com.btech.IucHostel.Helper.AppMemory;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class PersonalInfo extends AppCompatActivity {

    private final int ID_HOME = 1;
    private final int ID_SETTINGS = 2;
    private final int ID_LOGOUT = 3;
    private TextView userName, matricule, userRoom, paymentState, month, hostel, amtPaid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        userName = findViewById(R.id.userName);
        matricule = findViewById(R.id.matricule);
        userRoom = findViewById(R.id.userRoom);
        paymentState = findViewById(R.id.paymentState);
        month = findViewById(R.id.month);
        hostel = findViewById(R.id.hostel);
        amtPaid = findViewById(R.id.amtPaid);
//        userName = findViewById(R.id.userName);

        if (AppMemory.Current_Student==null){
            AppMemory.Current_Student = IUCDatabase.getInstance(this).localUserDao().getAll().get(0);
        }
        amtPaid.setText(AppMemory.Current_Student.getPaid());
        userName.setText(AppMemory.Current_Student.getUsername());
        matricule.setText(AppMemory.Current_Student.getUserMatricule());
        userRoom.setText(AppMemory.Current_Student.getUserRoomNumber());
        paymentState.setText(AppMemory.Current_Student.getPayementState());
        month.setText(AppMemory.Current_Student.getMonthRegistered());
        hostel.setText(AppMemory.Current_Student.getHostel());

        TextView selected_page =findViewById(R.id.selected_page);
        MeowBottomNavigation bottomNavigation = findViewById(R.id.btnNavigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME,R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_SETTINGS,R.drawable.ic_setting2));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_LOGOUT,R.drawable.ic_logout));

        IUCDatabase.getInstance(this).studentDao().getAll();

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item){
                Toast.makeText(PersonalInfo.this, "clicked item:" + item.getId(), Toast.LENGTH_SHORT).show();
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