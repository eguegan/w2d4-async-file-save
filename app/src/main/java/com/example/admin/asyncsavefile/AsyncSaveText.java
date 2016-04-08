package com.example.admin.asyncsavefile;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by admin on 4/8/2016.
 */
public class AsyncSaveText extends AsyncTask<Void, Void, Integer> {
    private EditText mEditText;
    private String inputText;
    private MainActivity mMainActivity;

    public AsyncSaveText(EditText mEt, MainActivity mMa){
        mEditText = mEt;
        mMainActivity = mMa;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        inputText = mEditText.getText().toString();
    }

    @Override
    protected Integer doInBackground(Void... params) {
        String root = Environment.getExternalStorageDirectory().toString();

        File gpxfile = new File(root, "text.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(gpxfile);
            writer.append(inputText);
            writer.flush();
            writer.close();

            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("TAG", "doInBackground: " + root);
            return 0;
        }
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        if(integer != null){
            if(integer == 1){
                Toast.makeText(mMainActivity, "Text saved!", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(mMainActivity, "Unable to save text :(", Toast.LENGTH_LONG).show();
            }
        }
    }
}
