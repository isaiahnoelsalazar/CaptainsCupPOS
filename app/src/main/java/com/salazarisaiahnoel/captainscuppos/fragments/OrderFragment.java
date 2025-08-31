package com.salazarisaiahnoel.captainscuppos.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salazarisaiahnoel.captainscuppos.R;
import com.salazarisaiahnoel.captainscuppos.adapters.OrderAdapter;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment {

    @SuppressLint("StaticFieldLeak")
    static Context context;
    static RecyclerView rv;
    static SQLiteOpenHelper sqLiteOpenHelper;

    public OrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = view.findViewById(R.id.orderrv);
        LinearLayoutManager llm = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);

        context = requireContext();
        sqLiteOpenHelper = new SQLiteOpenHelper(context, "ccdb", null, 1) {
            @Override
            public void onCreate(SQLiteDatabase db) {

            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            }
        };
        refresh();
    }

    public static void remove(String all){
        sqLiteOpenHelper.getWritableDatabase().execSQL("DELETE FROM cctable WHERE orders='" + all.split("~")[0] + "' AND barista='" + all.split("~")[1] + "' AND date_submitted='" + all.split("~")[2] + "' AND total='" + all.split("~")[3] + "'");
        refresh();
    }

    public static void refresh(){
        List<String> testing = new ArrayList<>();
        Cursor c = sqLiteOpenHelper.getWritableDatabase().rawQuery("SELECT * FROM cctable", null);
        while (c.moveToNext()){
            testing.add(c.getString(0) + ";" + c.getString(1) + ";" + c.getString(2) + ";" + c.getString(3));
        }
        c.close();
        OrderAdapter orderAdapter = new OrderAdapter(context, testing);
        rv.setAdapter(orderAdapter);
    }
}