package com.example.nguyenthanhit19.listview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrTen; //new 1 arrlist de tao collection giup thay doi data
    ArrayAdapter<String> adapterTen; //new adapter de noi chuyen doi
    ListView lvTen;

    EditText edtTen;
    Button btnLuu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addControl();
        addEvent();

    }

    private void addControl() {
        lvTen = (ListView) findViewById(R.id.lvTen);
        edtTen =( EditText) findViewById(R.id.edtTen);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        arrTen = new ArrayList<String>(); //new arrlist
        adapterTen = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrTen
        );
        //khoi tao adapter
        lvTen.setAdapter(adapterTen); //set Adapter

    }

    private void addEvent() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LuuDuLieu();
            }
        });
    }

    private void LuuDuLieu() {
        String ten = edtTen.getText().toString();
        arrTen.add(ten);
        adapterTen.notifyDataSetChanged(); // update lai adapter
        edtTen.requestFocus(); //di chuyen ve vi tri nhap lieu
    }
}
