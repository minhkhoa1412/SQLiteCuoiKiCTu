package com.nguyenchungtu.onthicuoiki.adapter;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nguyenchungtu.onthicuoiki.R;
import com.nguyenchungtu.onthicuoiki.model.HocSinh;
import com.nguyenchungtu.onthicuoiki.util.FormatHelper;

import java.util.List;

public class HocSinhAdapter extends ArrayAdapter<HocSinh>
{
    Activity context;
    List<HocSinh> objects;

    public HocSinhAdapter(@NonNull Activity context, int resource, @NonNull List<HocSinh> objects)
    {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        HocSinh hs = this.objects.get(position);
        View item;
        if (hs.isGioitinh() == true)
        {
            item = this.context.getLayoutInflater().inflate(
                    R.layout.item_hocsinh1,
                    null);
        }
        else
        {
            item = this.context.getLayoutInflater().inflate(
                    R.layout.item_hocsinh_2,
                    null);
        }
        TextView txtMaHS = item.findViewById(R.id.txtMaSo);
        TextView txtTenHS = item.findViewById(R.id.txtTen);
        TextView txtNgaySinh = item.findViewById(R.id.txtNgaySinh);
        TextView txtGioiTinh = item.findViewById(R.id.txtGioiTinh);

        txtMaHS.setText(hs.getMahs() + "");
        txtTenHS.setText(hs.getTenhs());
        txtNgaySinh.setText(FormatHelper.formatNgay(hs.getNgaysinh()));
        if (hs.isGioitinh() == true)
        {
            txtGioiTinh.setText("Nam");
        }
        else
        {
            txtGioiTinh.setText("Nữ");
        }

        return item;
    }

}
