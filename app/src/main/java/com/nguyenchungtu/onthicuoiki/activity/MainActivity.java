package com.nguyenchungtu.onthicuoiki.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nguyenchungtu.onthicuoiki.R;
import com.nguyenchungtu.onthicuoiki.adapter.HocSinhAdapter;
import com.nguyenchungtu.onthicuoiki.model.HocSinh;
import com.nguyenchungtu.onthicuoiki.util.CopyDatabase;
import com.nguyenchungtu.onthicuoiki.util.FormatHelper;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{

    ListView lvHS;
    ArrayList<HocSinh> dsHS;
    HocSinhAdapter adapter;
    //DATABASE
    static final String DATABASE_NAME = "DB_HocSinh.sqlite";
    static final String DB_PATH_SUFFIX = "/databases/";
    public static SQLiteDatabase database = null;

    public SQLiteDatabase getDatabase()
    {
        return database;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CopyDatabase.processCopyDatabase(this, DB_PATH_SUFFIX, DATABASE_NAME);
        addControls();

    }

    private void addControls()
    {
        lvHS = findViewById(R.id.lvHocSinh);
        dsHS = new ArrayList<>();
        adapter = new HocSinhAdapter(
                MainActivity.this, R.layout.item_hocsinh1, dsHS
        );
        lvHS.setAdapter(adapter);
        showList();

        lvHS.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                startActivity(new Intent(MainActivity.this,ChiTietActivity.class).putExtra("maso",dsHS.get(i).getMahs()));
            }
        });

    }

    private void showList()
    {
        database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        Cursor cursor = database.rawQuery("Select * From HocSinh", null);
        dsHS.clear();
        while (cursor.moveToNext())
        {
            int MaHS = cursor.getInt(0);
            String TenHS = cursor.getString(1);
            String NgaySinh = cursor.getString(2);
            String GioiTinh = cursor.getString(3);

            HocSinh hocSinh = new HocSinh();
            hocSinh.setMahs(MaHS);
            hocSinh.setTenhs(TenHS);
            try
            {
                hocSinh.setNgaysinh(FormatHelper.formatstring(NgaySinh));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            hocSinh.setGioitinh(Boolean.parseBoolean(GioiTinh));

            dsHS.add(hocSinh);
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }
}
