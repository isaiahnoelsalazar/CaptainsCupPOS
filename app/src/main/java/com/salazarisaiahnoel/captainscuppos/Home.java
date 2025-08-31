package com.salazarisaiahnoel.captainscuppos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import com.salazarisaiahnoel.captainscuppos.fragments.HomeFragment;
import com.salazarisaiahnoel.captainscuppos.fragments.OrderFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Home extends AppCompatActivity {

    public static Toolbar t;
    DrawerLayout dl;
    NavigationView nv;
    ActionBarDrawerToggle abdt;
    ConstraintLayout cart;
    static TextView cartTextView;
    public static List<String> cartItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        t = findViewById(R.id.toolbar);
        cart = t.findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Cart.class);
                startActivity(i);
            }
        });
        cartTextView = t.findViewById(R.id.carttv);
        cartTextView.setVisibility(View.GONE);
        dl = findViewById(R.id.main);
        nv = findViewById(R.id.navigation_view);
        setSupportActionBar(t);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        abdt = setupDrawerToggle();
        abdt.setDrawerIndicatorEnabled(true);
        abdt.syncState();
        dl.addDrawerListener(abdt);

        selectItem(nv.getMenu().findItem(R.id.section_products));
        View vvv = LayoutInflater.from(this).inflate(R.layout.adding, null);
        nv.addHeaderView(vvv);
        setupDrawer(nv);

        try {
            @SuppressLint("RestrictedApi") NavigationMenuView nmv = (NavigationMenuView) nv.getChildAt(0);
            if (nmv != null){
                nmv.setVerticalScrollBarEnabled(false);
            }
        } catch (Exception ignored){

        }
    }

    private ActionBarDrawerToggle setupDrawerToggle(){
        return new ActionBarDrawerToggle(this, dl, t, R.string.open, R.string.close);
    }

    private void setupDrawer(NavigationView nv){
        nv.setNavigationItemSelectedListener(item -> {
            selectItem(item);
            return true;
        });
    }

    private void selectItem(MenuItem item){
        Fragment f = null;
        Class<?> fc;
        if (item.getItemId() == R.id.section_products){
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.app_name);
            fc = HomeFragment.class;
        } else if (item.getItemId() == R.id.section_orders) {
            Objects.requireNonNull(getSupportActionBar()).setTitle("Orders");
            fc = OrderFragment.class;
        } else {
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.app_name);
            fc = HomeFragment.class;
        }

        try {
            f = (Fragment) fc.newInstance();
        } catch (Exception ignored){
        }

        FragmentManager fm = getSupportFragmentManager();
        assert f != null;
        fm.beginTransaction().replace(R.id.fragment_container, f).commit();

        dl.closeDrawers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshCart();
    }

    public static void refreshCart(){
        if (!cartItems.isEmpty()){
            cartTextView.setVisibility(View.VISIBLE);
            cartTextView.setText(String.valueOf(cartItems.size()));
        } else {
            cartTextView.setVisibility(View.GONE);
            cartTextView.setText(String.valueOf(cartItems.size()));
        }
    }
}