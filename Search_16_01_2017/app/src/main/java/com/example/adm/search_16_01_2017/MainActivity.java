package com.example.adm.search_16_01_2017;

import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    TextView tv;
    AutoCompleteTextView tvSelect;
    String[] NAME_CUSTOM = { "Radislav", "Vlad", "Vasya", "Uasya", "Kasya", "Sasya", "Eugeniy" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.test_view_test);
        tvSelect = (AutoCompleteTextView) findViewById(R.id.text_view_list_search);
        tvSelect.addTextChangedListener(this);
        tvSelect.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, NAME_CUSTOM));
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        tv.setText(tvSelect.getText());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
