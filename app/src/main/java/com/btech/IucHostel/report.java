package com.btech.IucHostel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    private String problemPath;

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

        /*capture_image_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCameraPermission()) {
                    getPickImageChooserIntent(false, CAMERA);
//                    startActivityForResult(chooserIntent, CAMERA);
                }
            }
        });*/

        /*find_in_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY);
            }
        });*/

        /*send_Reportbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

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

    private Uri getCaptureImageUri() {
        Uri outputFileUri = null;
        File getImage = getExternalFilesDir("images");
        if (getImage != null) {
            outputFileUri = FileProvider.getUriForFile(getApplicationContext(), getPackageName() + ".fileprovider", new File(getImage.getPath(), "profile.png"));
        }
        return outputFileUri;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            if (resultCode == Activity.RESULT_OK) {
                switch (requestCode) {
                    case CAMERA: {
                        Log.d("J-Purple", "onActivityResult()  non clip data selected");
                        String action = data.getAction();
                        boolean isCamera = false;
                        if (action != null) {
                            isCamera = action.equals(MediaStore.ACTION_IMAGE_CAPTURE);
                        }

                        if (isCamera) {
                            Log.d("J-Purple", "onActivityResult() action is ACTION_IMAGE_CAPTURE ");
                            Uri outputUri = data.getData();
                            Picasso.get().load(outputUri).into(image_view);
                            problemPath = outputUri.getPath();
                        } else {
                            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                            Uri inputUri = null;
                            Log.d("J-Purple", "onActivityResult() action is not ACTION_IMAGE_CAPTURE or null ");
                            File getImage = getExternalFilesDir("image");
                            if (getImage == null) {
                                Log.d("J-Purple", "getUrifromBitmap: getExternalFilesDir is null");
                                break;
                            }
                            Log.d("J-Purple", "getUrifromBitmap: getExternalFilesDir is not null");

                            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                            try {
                                File tempFile = new File(getImage.getPath(), "image_" + Calendar.getInstance().getTime().getTime() + ".png");
                                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                                FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
                                fileOutputStream.write(outputStream.toByteArray());
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                inputUri =  Uri.fromFile(tempFile);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Picasso.get().load(inputUri).into(image_view);
                            problemPath = inputUri.getPath();
                            Log.d("J-Purple", "onActivityResult() return uri from bitmap " + inputUri);
                        }
                    }break;
                    case GALLERY:{
                        Uri inputUri = null;
                        int clipData_itemCount = data.getClipData().getItemCount();
                        for (int i = 0; i < clipData_itemCount; i++) {
                            inputUri = data.getClipData().getItemAt(i).getUri();
                        }
                        problemPath = inputUri.getPath();
                        Picasso.get().load(inputUri).into(image_view);
                    }
                }
            }
        }
    }

    public Intent getPickImageChooserIntent(boolean multipleAllowed, int requestCode) {
        Uri outputFileUri = getCaptureImageUri();

        List<Intent> allIntents = new ArrayList<>();
        PackageManager packageManager = getPackageManager();

        Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        List<ResolveInfo> listCam = packageManager.queryIntentActivities(captureIntent, 0);
        for (ResolveInfo res : listCam) {
            Intent intent = new Intent(captureIntent);
            intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            intent.setPackage(res.activityInfo.packageName);
            if (outputFileUri != null) {
                captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
            }
            allIntents.add(intent);
        }

        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        if (multipleAllowed) {
            galleryIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        }
        List<ResolveInfo> listGallery = packageManager.queryIntentActivities(galleryIntent, 0);
        for (ResolveInfo res : listGallery) {
            Intent intent = new Intent(galleryIntent);
            intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            intent.setPackage(res.activityInfo.packageName);
            allIntents.add(intent);
        }

        // the main intent is the last in the list (fucking android) so pickup the useless one
        Intent mainIntent = allIntents.get(allIntents.size() - 1);
        for (Intent intent : allIntents) {
            mainIntent = intent;
            break;
        }
        allIntents.remove(mainIntent);

        // Create a chooser from the main intent
        Intent chooserIntent = Intent.createChooser(mainIntent, "Select source");

        // Add all other intents
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, allIntents.toArray(new Parcelable[allIntents.size()]));

        startActivityForResult(chooserIntent, requestCode);
        return chooserIntent;
    }

    private boolean checkCameraPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            int cameraPermission = ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA);
            if (cameraPermission == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 20);
                return false;
            }
        }
        return true;
    }
}