package com.crumali.asynctaskexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AsynkTaskListView extends AppCompatActivity {

    private ListView listView;
    private String[] names = {"Angelo", "Christian", "Kail", "Junius", "Patrick", "Brenz"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynk_task_list_view);
        intit();
    }

    private void intit() {
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));

    }

    class MyTask extends AsyncTask<Void, String, String> {

        ArrayAdapter<String> adapter;

        @Override
        protected void onPreExecute() {
            adapter = (ArrayAdapter<String>) listView.getAdapter();

        }

        @Override
        protected String doInBackground(Void... voids) {
            for (String Name : names) {
                publishProgress(Name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "All the Names were addded succesfully";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
        }


    }
}
