package com.example.challenge01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    Button buttonImage, buttonRegister;
    EditText editText01, editText02,editText03, editText04;
    RadioGroup radioGroup;
    CheckBox checkBox;
    Spinner spinner;
    RelativeLayout relativeLayout;

    ArrayList<String> countriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        buttonImage.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);
        checkBox.setOnCheckedChangeListener(this );
        spinner.setOnItemSelectedListener(this);

    }

    private void initViews() {
        buttonImage = findViewById(R.id.pickImage);
        buttonRegister = findViewById(R.id.buttonRegister);

        editText01 = findViewById(R.id.editTextName);
        editText02 = findViewById(R.id.editTextEmail);
        editText03 = findViewById(R.id.editTextPassword);
        editText04 = findViewById(R.id.editConfirmTextPassword);

        radioGroup = findViewById(R.id.radioGroup01);

        checkBox = findViewById(R.id.checkBox01);

        spinner = findViewById(R.id.spinner01);
        countriesList = new ArrayList<String>();

        relativeLayout = findViewById(R.id.parentRelative);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == buttonImage.getId() ) Toast.makeText(MainActivity.this, "Clicked image button", Toast.LENGTH_SHORT).show();

        else if ( v.getId() == buttonRegister.getId() ) {
            initRegister();

        }
    }

    public void initRegister() {
        if ( validatedData() ) {
            if ( checkBox.isChecked() ){
                showSnackBar();
            }else{
                Toast.makeText(MainActivity.this, "You need to agreed with the terms and conditions", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showSnackBar() {
        Snackbar.make(relativeLayout , "User registered", Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", v -> {}).show();
    }


    private boolean validatedData() {
        if ( editText01.getText().toString().equals("") ) {
            editText01.setHint("Introduce the name");
            return false;
        }

        if ( editText02.getText().toString().equals("") ) {
            editText02.setHint("Introduce the email");
            return false;
        }

        if ( editText03.getText().toString().equals("") ) {
            editText03.setHint("Introduce the password");
            return false;
        }

        if ( editText04.getText().toString().equals("") ) {
            editText04.setHint("Introduce the password confirmation");
            return false;
        }
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, parent.getSelectedItem().toString() + " selected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if ( R.id.radioButton01 == checkedId ) Toast.makeText(MainActivity.this,"Male selected", Toast.LENGTH_SHORT).show();
        else if ( R.id.radioButton02 == checkedId ) Toast.makeText(MainActivity.this,"Female selected", Toast.LENGTH_SHORT).show();
        else if ( R.id.radioButton03 == checkedId ) Toast.makeText(MainActivity.this,"Other selected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if ( buttonView.getId() == checkBox.getId() ) Toast.makeText(MainActivity.this,"Terms agreed", Toast.LENGTH_SHORT).show();
    }


}