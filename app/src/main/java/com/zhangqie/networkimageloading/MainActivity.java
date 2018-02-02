package com.zhangqie.networkimageloading;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zhangqie.networkimageloading.httpclients.HttpClientsActivity;
import com.zhangqie.networkimageloading.httpurlconnection.HttpConnectionActivity;
import com.zhangqie.networkimageloading.okhttp.OkHttpActivity;
import com.zhangqie.networkimageloading.volley.VolleyActivity;
import com.zhangqie.networkimageloading.xutis.XUtilsActivity;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private String[] arrayDate={"HttpURLConnection","HttpClients","Volley","XUtils","OkHttp"};
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        mListView=(ListView) findViewById(R.id.mListView);
        ArrayAdapter<String>  adapter=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,arrayDate);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                showIntent(position);

            }
        });
    }

    private void showIntent(int i)
    {
        switch (i) {
            case 0:
                intent=new Intent(MainActivity.this,HttpConnectionActivity.class);
                break;
            case 1:
                intent=new Intent(MainActivity.this,HttpClientsActivity.class);
                break;
            case 2:
                intent=new Intent(MainActivity.this,VolleyActivity.class);
                break;
            case 3:
                intent=new Intent(MainActivity.this,XUtilsActivity.class);
                break;
            case 4:
                intent=new Intent(MainActivity.this,OkHttpActivity.class);
                break;

            default:
                break;
        }
        startActivity(intent);
    }
}
