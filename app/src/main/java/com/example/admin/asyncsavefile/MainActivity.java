package com.example.admin.asyncsavefile;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.et_1);
    }

    public void saveText(View v){
        AsyncSaveText aSaveText = new AsyncSaveText(mEditText, this);
        aSaveText.execute();
    }
}
