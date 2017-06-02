package com.crumali.asynctaskexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {

    private TextView tv_progress;
    private Button btn_startdownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btn_startdownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask myTask = new MyTask(MainActivity.this, tv_progress, btn_startdownload);
                myTask.execute();
                btn_startdownload.setEnabled(false);
            }
        });
    }

    private void init() {
        tv_progress = (TextView) findViewById(R.id.tv_progress);
        btn_startdownload = (Button) findViewById(R.id.btn_download);
    }
}
