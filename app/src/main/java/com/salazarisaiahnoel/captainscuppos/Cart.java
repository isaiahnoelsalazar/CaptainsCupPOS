package com.salazarisaiahnoel.captainscuppos;

import static com.salazarisaiahnoel.captainscuppos.Home.cartItems;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.salazarisaiahnoel.captainscuppos.adapters.CartAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Cart extends AppCompatActivity {

    RecyclerView rv;
    String orders = "";
    String barista = "";
    String date = "";
    CartAdapter ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Toolbar t = findViewById(R.id.toolbar);
        setSupportActionBar(t);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        SQLiteOpenHelper sqLiteOpenHelper = new SQLiteOpenHelper(this, "ccdb", null, 1) {
            @Override
            public void onCreate(SQLiteDatabase db) {

            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            }
        };

        rv = findViewById(R.id.cartrv);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
        ConstraintLayout del = findViewById(R.id.del);
        ConstraintLayout save = findViewById(R.id.savebutton);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(Cart.this);
                View dialogView = layoutInflater.inflate(R.layout.rounded_alert_dialog_layout, null);
                final TextView texttitle = dialogView.findViewById(R.id.rounded_alert_dialog_title);
                AlertDialog.Builder builder = new AlertDialog.Builder(Cart.this)
                        .setView(dialogView);
                AlertDialog alertDialog = builder.create();
                Objects.requireNonNull(alertDialog.getWindow()).getDecorView().setBackgroundColor(Color.TRANSPARENT);
                texttitle.setText("Clear cart?");
                Button leftButton = dialogView.findViewById(R.id.rounded_alert_dialog_left_button);
                Button rightButton = dialogView.findViewById(R.id.rounded_alert_dialog_right_button);
                leftButton.setText("No");
                rightButton.setText("Yes");
                leftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                rightButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cartItems.clear();
                        showCart();
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(Cart.this);
                View dialogView = layoutInflater.inflate(R.layout.rounded_alert_dialog_layout_barista, null);
                final TextView texttitle = dialogView.findViewById(R.id.rounded_alert_dialog_title);
                EditText baristanametext = dialogView.findViewById(R.id.baristaname);
                AlertDialog.Builder builder = new AlertDialog.Builder(Cart.this)
                        .setView(dialogView);
                AlertDialog alertDialog = builder.create();
                Objects.requireNonNull(alertDialog.getWindow()).getDecorView().setBackgroundColor(Color.TRANSPARENT);
                texttitle.setText("Save cart");
                Button leftButton = dialogView.findViewById(R.id.rounded_alert_dialog_left_button);
                Button rightButton = dialogView.findViewById(R.id.rounded_alert_dialog_right_button);
                leftButton.setText("No");
                rightButton.setText("Yes");
                leftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                rightButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        barista = baristanametext.getText().toString();
                        Date date1 = new Date();
                        date = (date1.getMonth() + 1 < 10 ? "0" + (date1.getMonth() + 1) : date1.getMonth() + 1) + "/" + (date1.getDate() < 10 ? "0" + date1.getDate() : date1.getDate()) + "/" + (date1.getYear() + 1900);

                        for (int a = 0; a < ca.getOrderAndAmount().size(); a++){
                            if (a != ca.getOrderAndAmount().size() - 2){
                                orders += ca.getOrderAndAmount().get(a).split(";")[0] + ": " + ca.getOrderAndAmount().get(a).split(";")[1];
                            } else {
                                orders += ca.getOrderAndAmount().get(a).split(";")[0] + ": " + ca.getOrderAndAmount().get(a).split(";")[1] + "\n\n";
                            }
                        }

                        sqLiteOpenHelper.getWritableDatabase().execSQL("INSERT INTO cctable(orders, barista, date_submitted, total) VALUES ('" + orders + "', '" + barista + "', '" + date + "', '" + ca.getTotal() + "')");
                        cartItems.clear();
                        showCart();
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();
            }
        });

        showCart();
    }

    void showCart(){
        List<String> total = new ArrayList<>();
        List<String> total1 = new ArrayList<>();
        Collections.sort(cartItems);
        for (int a = 0; a < cartItems.size(); a++){
            if (!total1.contains(cartItems.get(a))){
                total1.add(cartItems.get(a));
            }
        }
        int totalAmount = 0;
        int totalPrice = 0;
        for (int a = 0; a < total1.size(); a++){
            String addonString = "";
            if (total1.get(a).split(":").length > 2){
                String addons = total1.get(a).split(":")[2];
                if (!addons.isEmpty()){
                    addonString = " (Add-ons: ";
                    int count = addons.length();
                    if (addons.contains("1")){
                        addonString += "Coffee Jelly";
                        totalPrice += 15;
                        if (count > 1){
                            addonString += ", ";
                            count--;
                        }
                    }
                    if (addons.contains("2")){
                        addonString += "Crystal Jelly";
                        totalPrice += 10;
                        if (count > 1){
                            addonString += ", ";
                            count--;
                        }
                    }
                    if (addons.contains("3")){
                        addonString += "White Mocha";
                        totalPrice += 20;
                        if (count > 1){
                            addonString += ", ";
                            count--;
                        }
                    }
                    if (addons.contains("4")){
                        addonString += "Popping Boba";
                        totalPrice += 15;
                    }
                    addonString += ")";
                }
            }
            totalAmount += Collections.frequency(cartItems, total1.get(a));
            totalPrice += (Integer.parseInt(total1.get(a).split(":")[1].replace("PHP ", "")) * Collections.frequency(cartItems, total1.get(a)));
            total.add(total1.get(a).split(":")[0] + addonString + ";" + Collections.frequency(cartItems, total1.get(a)) + ";" + (Integer.parseInt(total1.get(a).split(":")[1].replace("PHP ", "")) * Collections.frequency(cartItems, total1.get(a))));
        }

        total.add("Total;" + totalAmount + ";" + totalPrice);

        ca = new CartAdapter(total);
        rv.setAdapter(ca);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}