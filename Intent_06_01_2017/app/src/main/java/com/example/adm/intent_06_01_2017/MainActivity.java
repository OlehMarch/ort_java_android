package com.example.adm.intent_06_01_2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPhone;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.main_activity_edit_text_name);
        etPhone = (EditText) findViewById(R.id.main_activity_edit_text_phone);
        btn = (Button) findViewById(R.id.main_activity_button_save);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("nameKey", etName.getText().toString());
                intent.putExtra("phoneKey", etPhone.getText().toString());
                startActivity(intent);
            }
        });
    }

}
