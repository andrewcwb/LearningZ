package com.example.andre.learningz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.andre.adapters.CustomListAdapter;
import com.example.andre.entity.ListItem;

import java.util.ArrayList;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        ArrayList<ListItem> listData = getListData();

        final ListView listView = (ListView) findViewById(R.id.custom_list);
        listView.setAdapter(new CustomListAdapter(this, listData));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                ListItem newsData = (ListItem) listView.getItemAtPosition(position);
                switch (newsData.getActivityRow()){
                    case "LoginActivity":
                        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Selected :" + " " + newsData.getActivityRow(), Toast.LENGTH_LONG).show();

                }

            }
        });

    }

    private ArrayList<ListItem> getListData() {
        ArrayList<ListItem> listMockData = new ArrayList<ListItem>();
        String[] images = getResources().getStringArray(R.array.images_array);
        String[] headlines = getResources().getStringArray(R.array.headline_array);
        String[] activityRow = getResources().getStringArray(R.array.activity_array);
        String[] descriptions = getResources().getStringArray(R.array.description_array);
        String[] dateRow = getResources().getStringArray(R.array.date_array);

        for (int i = 0; i < images.length; i++) {
            ListItem newsData = new ListItem();
            newsData.setUrl(images[i]);
            newsData.setHeadline(headlines[i]);
            newsData.setActivityRow(activityRow[i]);
            newsData.setDescription(descriptions[i]);
            newsData.setReporterName("André");
            newsData.setDate(dateRow[i]);
            listMockData.add(newsData);
        }
        return listMockData;
    }


}

