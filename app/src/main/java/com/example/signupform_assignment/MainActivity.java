package com.example.signupform_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.FileReader;
import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    EditText   editTextDate, cityText, countryText,  nameEditText, emailEditText, passwordEditText, confirmPasswordEditText;;
    RadioButton maleRadioButton, femaleRadioButton , beginerRadio , advanceRadio;

    CheckBox termsCheckBox, skills1, skills2, skills3;

    Button register ,clearBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText=(EditText) findViewById(R.id.nameEditText);
       emailEditText=findViewById(R.id.emailEditText);
       passwordEditText=findViewById(R.id.passwordEditText);
        confirmPasswordEditText=findViewById(R.id.confirmPasswordEditText);
       maleRadioButton=findViewById(R.id.maleRadioButton);
       femaleRadioButton=findViewById(R.id.femaleRadioButton);
        termsCheckBox =findViewById(R.id.termsCheckBox);
        cityText=findViewById(R.id.cityText);
        countryText=findViewById(R.id.countryText);
        beginerRadio=findViewById(R.id.beginerRadio);
        advanceRadio=findViewById(R.id.advanceRadio);
        skills1=findViewById(R.id.skills1);
        skills2=findViewById(R.id.skills2);
        skills3=findViewById(R.id.skills3);
       clearBtn=findViewById(R.id.clearButton);
       register=findViewById(R.id.submitBtn);


       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String name = nameEditText.getText().toString();
               String email = emailEditText.getText().toString();

               String password = passwordEditText.getText().toString();
               String confirmPassword = confirmPasswordEditText.getText().toString();
               boolean termsAccepted = termsCheckBox.isChecked();
              if (name.isEmpty()){
                  nameEditText.setError("name is required");
              }
              if (email.isEmpty()){
                  emailEditText.setError("email is required");
              }

               if (!password.equals(confirmPassword)) {

                   Toast.makeText(MainActivity.this, "Passwords do not match. Please enter matching passwords.", Toast.LENGTH_SHORT).show();
                   return;
               }
               if (!termsAccepted) {
                   Toast.makeText(MainActivity.this, "Please accept the terms and conditions.", Toast.LENGTH_SHORT).show();
                   return;
               }
               String userDetails = "Name: " + name + "\nEmail: " + email + "\nPassword:" +password   ;

               Toast.makeText(MainActivity.this,userDetails, Toast.LENGTH_SHORT).show();
           }
       });



      clearBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            nameEditText.setText("");
            emailEditText.setText("");
            passwordEditText.setText("");
            confirmPasswordEditText.setText("");
            maleRadioButton.setChecked(false);
            femaleRadioButton.setChecked(false);
            termsCheckBox.setChecked(false);
            cityText.setText("");
            countryText.setText("");
            skills1.setChecked(false);
            skills2.setChecked(false);
            skills3.setChecked(false);
            beginerRadio.setChecked(false);
            advanceRadio.setChecked(false);
          }
      });
    }


}