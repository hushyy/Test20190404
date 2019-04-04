package com.example.jsjx.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private Spinner sp_sheng;
private Spinner sp_shi;
private TextView tv_show_sp;
private String sheng[];
private String shi[][];
private int show_sp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
        sp_sheng.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sheng));
        sp_sheng.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                show_sp=position;
                sp_shi.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,shi[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp_shi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv_show_sp.setText(sheng[show_sp]+shi[show_sp][position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initDate() {
       sheng=new String[]{"山西省","陕西省"};
       shi=new String[][]{{"太原市","晋城市","晋中市"},{"西安市","宝鸡市","咸阳市"}};
}
    private void initView() {
        sp_sheng=findViewById(R.id.sp_sheng);
        sp_shi=findViewById(R.id.sp_shi);
        tv_show_sp=findViewById(R.id.tv_show_sp);
    }
}
