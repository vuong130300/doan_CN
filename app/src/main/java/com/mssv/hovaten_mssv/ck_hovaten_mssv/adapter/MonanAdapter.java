package com.mssv.hovaten_mssv.ck_hovaten_mssv.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mssv.hovaten_mssv.ck_hovaten_mssv.R;
import com.mssv.hovaten_mssv.ck_hovaten_mssv.database.Database;
import com.mssv.hovaten_mssv.ck_hovaten_mssv.model.Monan;

import java.util.ArrayList;

public class MonanAdapter extends BaseAdapter {
    final String DATABASE_NAME = "dbMonan.sqlite";

    Activity context;
    ArrayList<Monan> list;

    public MonanAdapter(Activity context, ArrayList<Monan> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.item, null);
        TextView txtMa = row.findViewById(R.id.txtMa);
        TextView txtTen = row.findViewById(R.id.txtTen);
        TextView txtLoai = row.findViewById(R.id.txtLoai);

        Monan monan = list.get(position);
        txtMa.setText(monan.getMa() + "");
        txtTen.setText(monan.getTenMonan());
        txtLoai.setText(monan.getLoaiMonan());

        row.setOnLongClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setIcon(android.R.drawable.ic_delete);
            builder.setTitle("Xóa Món Ăn");
            builder.setMessage("Bạn có muốn xóa?");
//            builder.setPositiveButton("có", (dialog, which) -> delete(monan.getMa()));
//            builder.setNegativeButton("không", (dialog, which) -> {
//            });
            //bug mất nút xóa
            AlertDialog dialog = builder.create();
            dialog.show();
            return false;
        });
        return row;
    }

    private void delete(int id) {
//        SQLiteDatabase database = Database.initDatabase(context, DATABASE_NAME);
        //bug : ket noi database
        database.delete("monan", "ma = ?", new String[]{id + ""});
//        list.clear();
        Cursor cursor = database.rawQuery("SELECT * FROM monan", null);
        while (cursor.moveToNext()) {
            int ma = cursor.getInt(0);
            String tenmonan = cursor.getString(1);
            String loaimonan = cursor.getString(2);

            list.add(new Monan(ma, tenmonan, loaimonan));
        }
        notifyDataSetChanged();
    }
}
