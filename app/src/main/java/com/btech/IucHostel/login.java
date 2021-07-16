package com.btech.IucHostel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.btech.IucHostel.Database.Entities.Localuser;
import com.btech.IucHostel.Database.Entities.Student;
import com.btech.IucHostel.Database.IUCDatabase;
import com.btech.IucHostel.Helper.AppMemory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class login extends AppCompatActivity {

    private EditText editTextMatricule, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (IUCDatabase.getInstance(this).localUserDao().getAll().isEmpty()){
            setContentView(R.layout.activity_login);
            editTextPassword = findViewById(R.id.editTextPassword);
            editTextMatricule = findViewById(R.id.editTextMatricule);
        } else {
            Intent intent = new Intent(login.this, MainActivity2.class);
            startActivity(intent);
            finish();
        }

       //getSupportActionBar().hide();
    }


    public void nextStep(View view) {
        String matricule = editTextMatricule.getText().toString();
        String password = editTextPassword.getText().toString();
        if (TextUtils.isEmpty(matricule)||TextUtils.isEmpty(password)){
            invalidLogin();
            return;
        }
        Student testStudent = IUCDatabase.getInstance(this).studentDao().getFromKeyPair(matricule,md5(password));
        if (testStudent==null){
            invalidLogin();
        } else{
            AppMemory.Current_Student = testStudent;
            IUCDatabase.getInstance(this).localUserDao().insert(new Localuser(testStudent));
            Intent intent = new Intent(login.this, MainActivity2.class);
            startActivity(intent);
            finish();
        }
    }

    private String md5(String password){
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(password.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));

            Log.d("J-Purple", "md5: "+hexString.toString().toUpperCase());
            return hexString.toString().toUpperCase();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private void invalidLogin(){
        Toast.makeText(this, "Corresponding user not found", Toast.LENGTH_SHORT).show();
    }
}
