package com.nguyenchungtu.onthicuoiki.activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.nguyenchungtu.onthicuoiki.R;
import com.nguyenchungtu.onthicuoiki.util.FormatHelper;

public class ChiTietActivity extends AppCompatActivity
{
    TextView txtTen , txtNgaySinh , txtMaSo ,txtGioiTinh;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        txtTen = findViewById(R.id.txtTen);
        txtNgaySinh = findViewById(R.id.txtNgaySinh);
        txtGioiTinh = findViewById(R.id.txtGioiTinh);
        txtMaSo = findViewById(R.id.txtMaSo);

        Intent intent = getIntent();
        int maso = intent.getIntExtra("maso",-1);
        Cursor cursor = MainActivity.database.rawQuery("SELECT * FROM HocSinh WHERE MaHS = '"+String.valueOf(maso)+"' ", null);
        while (cursor.moveToNext())
        {
            txtMaSo.setText(String.valueOf(maso));
            txtTen.setText(cursor.getString(1));
            txtNgaySinh.setText(cursor.getString(2));
            if ( cursor.getString(3).equals("true"))
            {
                txtGioiTinh.setText("Đực");
            }
            else
            {
                txtGioiTinh.setText("Cái");
            }
        }
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
    }
}
