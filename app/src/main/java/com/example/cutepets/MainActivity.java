package com.example.cutepets;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;

/**
 * The main application activity. The automatic activity tracking is enabled in {@link
 * MyApp#onCreate()}. Most of the class is boilerplate template generated by Android Studio. The
 * Google Analytics code is added to onOptionsItemSelected handler to log an event when settings are
 * selected from the menu.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void begin(View view) {
        // Set custom dimensions to track gender, age group, and pets owned for the current user.
        // Custom dimensions must first be configured using the Google Analytics web interface.

        RadioGroup rgGender = (RadioGroup) findViewById(R.id.gendergroup);
        if (rgGender != null) {
            MyApp.tracker().set("&cd1", getSelectedGender(rgGender));
        }

        RadioGroup rgAge = (RadioGroup) findViewById(R.id.agegroup);
        if (rgAge != null) {
            MyApp.tracker().set("&cd2", getSelectedAge(rgAge));
        }

        CheckBox cbCats = (CheckBox) findViewById(R.id.cats);
        if (cbCats != null) {
            if (cbCats.isChecked()) {
                MyApp.tracker().set("&cd3", "Yes");
            } else {
                MyApp.tracker().set("&cd3", "No");
            }
        }

        CheckBox cbDogs = (CheckBox) findViewById(R.id.dogs);
        if (cbDogs != null) {
            if (cbDogs.isChecked()) {
                MyApp.tracker().set("&cd4", "Yes");
            } else {
                MyApp.tracker().set("&cd4", "No");
            }
        }

        startActivity(new Intent(this, Instructions.class));
    }

    @Nullable
    private String getSelectedGender(RadioGroup rgGender) {
        String gender = null;

        switch (rgGender.getCheckedRadioButtonId()) {
            case R.id.male:
                gender = "Male";
                break;
            case R.id.female:
                gender = "Female";
                break;
            case R.id.other:
                gender ="Other";
                break;
        }
        return gender;
    }

    @Nullable
    private String getSelectedAge(RadioGroup rgAge) {
        String age = null;

        switch (rgAge.getCheckedRadioButtonId()) {
            case R.id.young:
                age = "Young";
                break;
            case R.id.middle:
                age = "Middle";
                break;
            case R.id.old:
                age = "Old";
                break;
        }
        return age;
    }
}
