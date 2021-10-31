package com.example.patientregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    public static final String NAME = "com.example.patientregistration.NAME";
    public static final String ADDRESS = "com.example.patientregistration.ADDRESS";
    public static final String AGE = "com.example.patientregistration.AGE";
    public static final String DOB = "com.example.patientregistration.DOB";
    public static final String GENDER = "com.example.patientregistration.GENDER";
    public static final String STATUS = "com.example.patientregistration.STATUS";
    public static final String CONTACT = "com.example.patientregistration.CONTACT";
    public static final String REGTIME = "com.example.patientregistration.REGTIME";
    public static final String ADDICTION = "com.example.patientregistration.ADDICTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button reset_btn = (Button)findViewById(R.id.buttonReset);
        reset_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                EditText name = (EditText)findViewById(R.id.editTextName);
                name.setText("");
                EditText address = (EditText)findViewById(R.id.editTextAddress);
                address.setText("");
                EditText age = (EditText)findViewById(R.id.editTextAge);
                age.setText("");
                EditText dob = (EditText)findViewById(R.id.editTextDOB);
                dob.setText("");
                EditText contact = (EditText)findViewById(R.id.editTextContact);
                contact.setText("");
                EditText time = (EditText)findViewById(R.id.editTextTime);
                time.setText("");

                RadioButton male = (RadioButton) findViewById(R.id.radioButtonMale);
                male.setChecked(false);
                RadioButton female = (RadioButton) findViewById(R.id.radioButtonFemale);
                female.setChecked(false);

                RadioButton other = (RadioButton) findViewById(R.id.radioButtonOther);
                other.setChecked(false);


//                RadioGroup gender = (RadioGroup) findViewById(R.id.radioGroupSex);
//                gender.clearCheck();
                CheckBox smoke = (CheckBox)findViewById(R.id.checkBoxSmoke);
                if(smoke.isChecked()){
                    smoke.setChecked(false);
                }
                CheckBox alcohol = (CheckBox)findViewById(R.id.checkBoxAlcohol);
                if(alcohol.isChecked()){
                    alcohol.setChecked(false);
                }
                Spinner marital = (Spinner)findViewById(R.id.spinner);
                marital.setSelection(0);
            }
        });
    }

    public void submitFields(View view){
        Intent intent = new Intent(this, DisplayDetailsActivity.class);
        EditText name = (EditText) findViewById(R.id.editTextName);
        String message = name.getText().toString();
        intent.putExtra(NAME, message);

        EditText address = (EditText) findViewById(R.id.editTextAddress);
        String addr = address.getText().toString();
        intent.putExtra(ADDRESS, addr);

        EditText age = (EditText) findViewById(R.id.editTextAge);
        String age_y = age.getText().toString();
        intent.putExtra(AGE, age_y);

        EditText dob = (EditText) findViewById(R.id.editTextDOB);
        String date = dob.getText().toString();
        intent.putExtra(DOB, date);

        EditText contact = (EditText) findViewById(R.id.editTextContact);
        String number = contact.getText().toString();
        intent.putExtra(CONTACT, number);

        EditText regtime = (EditText) findViewById(R.id.editTextTime);
        String time = regtime.getText().toString();
        intent.putExtra(REGTIME, time);

        String gender="other";

//        RadioGroup sex = (RadioGroup)findViewById(R.id.radioGroupSex);
//        int selected = sex.getCheckedRadioButtonId();
//        RadioButton gen = (RadioButton)findViewById(selected);
//        String gender = gen.getText().toString();
        RadioButton male = (RadioButton) findViewById(R.id.radioButtonMale);
        RadioButton female = (RadioButton) findViewById(R.id.radioButtonFemale);
        RadioButton other = (RadioButton) findViewById(R.id.radioButtonOther);
        if(male.isChecked()){
            gender = male.getText().toString();
        }
        else if(female.isChecked()) {
            gender = female.getText().toString();
        }
        else{
            gender = other.getText().toString();
        }
        intent.putExtra(GENDER, gender);

        Spinner status = (Spinner) findViewById(R.id.spinner);
        String stat = status.getSelectedItem().toString();
        intent.putExtra(STATUS, stat);

        String addiction = "";
        CheckBox smoke  = (CheckBox) findViewById(R.id.checkBoxSmoke);
        if(smoke.isChecked()) {
            addiction += smoke.getText().toString();
        }
        CheckBox alcohol  = (CheckBox) findViewById(R.id.checkBoxAlcohol);
        if(alcohol.isChecked()){
            if(smoke.isChecked()) {
                addiction += ", ";
            }
            addiction += alcohol.getText().toString();
        }
        intent.putExtra(ADDICTION, addiction);

        startActivity(intent);
    }

}