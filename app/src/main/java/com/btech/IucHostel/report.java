package com.btech.IucHostel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import java.io.File;

public class report extends AppCompatActivity {
    private final int ID_HOME = 1;
    private final int ID_SETTINGS = 2;
    private final int ID_LOGOUT = 3;
    private final int CAMERA = 4;
    private final int GALLERY = 5;

    Button mCaptureBtn;
    private ImageView image_view;
    private Button capture_image_btn, find_in_gallery, send_Reportbtn;
    private EditText problemDescription;
    private ListView problems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        problems = findViewById(R.id.problems);
        problemDescription = findViewById(R.id.problemDescription);
        capture_image_btn = findViewById(R.id.capture_image_btn);
        find_in_gallery = findViewById(R.id.find_in_gallery);
        send_Reportbtn = findViewById(R.id.send_Reportbtn);
        TextView selected_page = findViewById(R.id.selected_page);
        MeowBottomNavigation bottomNavigation = findViewById(R.id.btnNavigation);

        capture_image_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = getCaptureImageUri();
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (uri != null) {
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                }
                startActivityForResult(intent, CAMERA);
            }
        });

        find_in_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY);
            }
        });

        send_Reportbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_SETTINGS, R.drawable.ic_setting2));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_LOGOUT, R.drawable.ic_logout));
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                switch (item.getId()) {

                    case ID_SETTINGS: {
                        Intent intent = new Intent(report.this, settings.class);
                        startActivity(intent);
                    }
                    break;
                    case ID_LOGOUT: {
                        MainActivity2.logOut(report.this);
                    }
                    break;
                    default: {
                        Intent intent = new Intent(report.this, MainActivity2.class);
                        startActivity(intent);
                    }
                }
            }
        });
        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                String name;
//                switch (item.getId()){
//
//                    case ID_HOME: name ="Home";
//                        break;
//                    case ID_SETTINGS: name ="settings";
//                        break;
//                    case ID_LOGOUT: name ="logout";
//                        break;
//                    default: name ="Account";
//                }
//                selected_page.setText(getString(R.string.main_page_selected));
            }
        });
    }

    private Uri getCaptureImageUri(){
        Uri outputFileUri = null;
        File getImage = getExternalCacheDir();
        if (getImage != null) {
            outputFileUri = Uri.fromFile(new File(getImage.getPath(), "profile.png"));
        }
        return outputFileUri;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}