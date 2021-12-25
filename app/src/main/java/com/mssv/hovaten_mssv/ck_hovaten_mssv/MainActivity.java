package com.mssv.hovaten_mssv.ck_hovaten_mssv;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.mssv.hovaten_mssv.ck_hovaten_mssv.adapter.MonanAdapter;
import com.mssv.hovaten_mssv.ck_hovaten_mssv.database.Database;
import com.mssv.hovaten_mssv.ck_hovaten_mssv.model.Monan;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String DATABASE_NAME = "dbMonan.sqlite";
    SQLiteDatabase database;

    ListView lvMonan;
    ArrayList<Monan> list;
    MonanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        //readData(); //bug: cannot load data
    }

    private void addControls() {
        lvMonan = findViewById(R.id.lvMonan);
        list = new ArrayList<>();
        adapter = new MonanAdapter(this, list);
        lvMonan.setAdapter(adapter);
    }

    private void readData() {
        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM monan1", null);//bug: cannot load data
        list.clear();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            int ma = cursor.getInt(0);
            String tenmonan = cursor.getString(1);
            String loaimonan = cursor.getString(2);

            list.add(new Monan(ma, tenmonan, loaimonan));
        }
        adapter.notifyDataSetChanged();
    }

}