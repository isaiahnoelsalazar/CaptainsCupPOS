package com.salazarisaiahnoel.captainscuppos.fragments;

import static com.salazarisaiahnoel.captainscuppos.Home.cartItems;
import static com.salazarisaiahnoel.captainscuppos.Home.refreshCart;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.salazarisaiahnoel.captainscuppos.R;
import com.salazarisaiahnoel.captainscuppos.adapters.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeAdapter.OnItemClickListener {

    RecyclerView rv1, rv2, rv3, rv4, rv5, rv6, rv7;
    HomeAdapter homeAdapter1;
    HomeAdapter homeAdapter2;
    HomeAdapter homeAdapter3;
    HomeAdapter homeAdapter4;
    HomeAdapter homeAdapter5;
    HomeAdapter homeAdapter6;
    HomeAdapter homeAdapter7;
    LinearLayout ll1, ll2, ll3, ll4, ll5, ll6, ll7;
    ImageView i1, i2, i3, i4, i5, i6, i7;
    LinearLayout ll11, ll22, ll33, ll44, ll55, ll66, ll77;
    boolean l1, l2, l3, l4, l5, l6, l7;
    boolean cof = false, cry = false, wm = false, pb = false;

    List<String> hotdata = new ArrayList<>();
    List<String> colddata = new ArrayList<>();
    List<String> frapcofdata = new ArrayList<>();
    List<String> frapcredata = new ArrayList<>();
    List<String> mtdata = new ArrayList<>();
    List<String> refdata = new ArrayList<>();
    List<String> snadata = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ll1 = view.findViewById(R.id.hotll);
        ll2 = view.findViewById(R.id.coldll);
        ll3 = view.findViewById(R.id.frapcofll);
        ll4 = view.findViewById(R.id.frapcrell);
        ll5 = view.findViewById(R.id.mtll);
        ll6 = view.findViewById(R.id.refll);
        ll7 = view.findViewById(R.id.snall);
        ll11 = view.findViewById(R.id.hotll1);
        ll22 = view.findViewById(R.id.coldll1);
        ll33 = view.findViewById(R.id.frapcofll1);
        ll44 = view.findViewById(R.id.frapcrell1);
        ll55 = view.findViewById(R.id.mtll1);
        ll66 = view.findViewById(R.id.refll1);
        ll77 = view.findViewById(R.id.snall1);
        i1 = view.findViewById(R.id.hoti);
        i2 = view.findViewById(R.id.coldi);
        i3 = view.findViewById(R.id.frapcofi);
        i4 = view.findViewById(R.id.frapcrei);
        i5 = view.findViewById(R.id.mti);
        i6 = view.findViewById(R.id.refi);
        i7 = view.findViewById(R.id.snai);

        rv1 = view.findViewById(R.id.hotrv);
        rv2 = view.findViewById(R.id.coldrv);
        rv3 = view.findViewById(R.id.frapcofrv);
        rv4 = view.findViewById(R.id.frapcrerv);
        rv5 = view.findViewById(R.id.mtrv);
        rv6 = view.findViewById(R.id.refrv);
        rv7 = view.findViewById(R.id.snarv);
        LinearLayoutManager llm1 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager llm2 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager llm3 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager llm4 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager llm5 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager llm6 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager llm7 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rv1.setLayoutManager(llm1);
        rv2.setLayoutManager(llm2);
        rv3.setLayoutManager(llm3);
        rv4.setLayoutManager(llm4);
        rv5.setLayoutManager(llm5);
        rv6.setLayoutManager(llm6);
        rv7.setLayoutManager(llm7);

        hotdata.add("1:Americano:58");
        hotdata.add("1:Cappuccino:68");
        hotdata.add("1:Latte:75");
        hotdata.add("1:Flat White:80");
        hotdata.add("1:Caramel Latte:90");
        hotdata.add("1:Vanilla Latte:90");
        hotdata.add("1:Hazelnut Latte:90");
        hotdata.add("1:Caramel Macchiato:95");
        hotdata.add("1:Cafe Mocha:95");
        hotdata.add("1:White Chocolate Mocha:99");
        hotdata.add("1:Asian Dolce Latte:99");
        hotdata.add("1:Captain's Choice Hot Chocolate:88");

        colddata.add("2:Iced Americano:63");
        colddata.add("2:Iced Latte:80");
        colddata.add("2:Iced Caramel Latte:95");
        colddata.add("2:Iced Vanilla Latte:95");
        colddata.add("2:Iced Hazelnut Latte:95");
        colddata.add("2:Iced Caramel Macchiato:110");
        colddata.add("2:Iced Mocha:110");
        colddata.add("2:Iced White Chocolate Mocha:118");
        colddata.add("2:Iced Asian Dolce Latte:118");
        colddata.add("2:Iced Praline Mocha:120");
        colddata.add("2:Captain's Choice Iced Chocolate:92");

        frapcofdata.add("3:Mocha Frappuccino:125");
        frapcofdata.add("3:White Chocolate Mocha:130");
        frapcofdata.add("3:Caramel Frappuccino:125");
        frapcofdata.add("3:Praline Mocha Frappuccino:130");
        frapcofdata.add("3:Caramel Coffee Jelly Frappuccino:135");
        frapcofdata.add("3:Java Chip Frappuccino:135");

        frapcredata.add("4:Chocolate Cream Frappuccino:120");
        frapcredata.add("4:Caramel Cream Frappuccino:120");
        frapcredata.add("4:Strawberry Cream Chip Frappuccino:120");
        frapcredata.add("4:Chocolate Chip Cream Frappuccino:125");

        mtdata.add("5:Wintermelon Milk Tea:83");
        mtdata.add("5:Okinawa Milk Tea:83");

        refdata.add("6:Iced Ocean Blue Lemonade:50");
        refdata.add("6:Ice Seafoam Kiwi Lemonade:70");
        refdata.add("6:Ice Red Sea Berry Lemonade:70");

        snadata.add("7:Three - Cheeze Quezadilla:68");
        snadata.add("7:Choco Nutella Banana Crepe:68");
        snadata.add("7:Cheezy Chicken Quezadilla:86");
        snadata.add("7:Beef Mexican Quezadilla:106");
        snadata.add("7:Beef Turkish Quezadilla:106");
        snadata.add("7:Beef Arabic Quezadilla:106");

        homeAdapter1 = new HomeAdapter(hotdata, this);
        homeAdapter2 = new HomeAdapter(colddata, this);
        homeAdapter3 = new HomeAdapter(frapcofdata, this);
        homeAdapter4 = new HomeAdapter(frapcredata, this);
        homeAdapter5 = new HomeAdapter(mtdata, this);
        homeAdapter6 = new HomeAdapter(refdata, this);
        homeAdapter7 = new HomeAdapter(snadata, this);
        rv1.setAdapter(homeAdapter1);
        rv2.setAdapter(homeAdapter2);
        rv3.setAdapter(homeAdapter3);
        rv4.setAdapter(homeAdapter4);
        rv5.setAdapter(homeAdapter5);
        rv6.setAdapter(homeAdapter6);
        rv7.setAdapter(homeAdapter7);

        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!l1){
                    ll11.setVisibility(View.VISIBLE);
                    l1 = true;
                    i1.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                } else {
                    ll11.setVisibility(View.GONE);
                    l1 = false;
                    i1.setImageResource(R.drawable.baseline_arrow_right_24);
                }
            }
        });
        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!l2){
                    ll22.setVisibility(View.VISIBLE);
                    l2 = true;
                    i2.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                } else {
                    ll22.setVisibility(View.GONE);
                    l2 = false;
                    i2.setImageResource(R.drawable.baseline_arrow_right_24);
                }
            }
        });
        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!l3){
                    ll33.setVisibility(View.VISIBLE);
                    l3 = true;
                    i3.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                } else {
                    ll33.setVisibility(View.GONE);
                    l3 = false;
                    i3.setImageResource(R.drawable.baseline_arrow_right_24);
                }
            }
        });
        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!l4){
                    ll44.setVisibility(View.VISIBLE);
                    l4 = true;
                    i4.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                } else {
                    ll44.setVisibility(View.GONE);
                    l4 = false;
                    i4.setImageResource(R.drawable.baseline_arrow_right_24);
                }
            }
        });
        ll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!l5){
                    ll55.setVisibility(View.VISIBLE);
                    l5 = true;
                    i5.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                } else {
                    ll55.setVisibility(View.GONE);
                    l5 = false;
                    i5.setImageResource(R.drawable.baseline_arrow_right_24);
                }
            }
        });
        ll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!l6){
                    ll66.setVisibility(View.VISIBLE);
                    l6 = true;
                    i6.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                } else {
                    ll66.setVisibility(View.GONE);
                    l6 = false;
                    i6.setImageResource(R.drawable.baseline_arrow_right_24);
                }
            }
        });
        ll7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!l7){
                    ll77.setVisibility(View.VISIBLE);
                    l7 = true;
                    i7.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                } else {
                    ll77.setVisibility(View.GONE);
                    l7 = false;
                    i7.setImageResource(R.drawable.baseline_arrow_right_24);
                }
            }
        });
    }

    @Override
    public void onItemClick(int position, String type) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        View v = LayoutInflater.from(requireContext()).inflate(R.layout.bottomsheet, null);
        TextView tv = v.findViewById(R.id.bsheettext);
        TextView tvprice = v.findViewById(R.id.bsheetprice);
        EditText num = v.findViewById(R.id.editText);
        LinearLayout addcofj = v.findViewById(R.id.addcofj);
        LinearLayout addcryj = v.findViewById(R.id.addcryj);
        LinearLayout addwm = v.findViewById(R.id.addwm);
        LinearLayout addpb = v.findViewById(R.id.addpb);
        ImageView addcofjimg = v.findViewById(R.id.addcofjimg);
        ImageView addcryjimg = v.findViewById(R.id.addcryjimg);
        ImageView addwmimg = v.findViewById(R.id.addwmimg);
        ImageView addpbimg = v.findViewById(R.id.addpbimg);
        TextView addcofjtext = v.findViewById(R.id.addcofjtext);
        TextView addcryjtext = v.findViewById(R.id.addcryjtext);
        TextView addwmtext = v.findViewById(R.id.addwmtext);
        TextView addpbtext = v.findViewById(R.id.addpbtext);
        addcofj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cof){
                    addcofj.setBackground(requireContext().getDrawable(R.drawable.ripplebrown));
                    addcofjimg.setImageResource(R.drawable.baseline_remove_24);
                    addcofjtext.setTextColor(requireContext().getColor(R.color.white));
                    cof = true;
                } else {
                    TypedArray ta = requireContext().obtainStyledAttributes(new int[]{androidx.appcompat.R.attr.selectableItemBackground});
                    addcofj.setBackground(ta.getDrawable(0));
                    ta.recycle();
                    addcofjimg.setImageResource(R.drawable.baseline_add_24);
                    addcofjtext.setTextColor(requireContext().getColor(R.color.black));
                    cof = false;
                }
            }
        });
        addcryj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cry){
                    addcryj.setBackground(requireContext().getDrawable(R.drawable.ripplebrown));
                    addcryjimg.setImageResource(R.drawable.baseline_remove_24);
                    addcryjtext.setTextColor(requireContext().getColor(R.color.white));
                    cry = true;
                } else {
                    TypedArray ta = requireContext().obtainStyledAttributes(new int[]{androidx.appcompat.R.attr.selectableItemBackground});
                    addcryj.setBackground(ta.getDrawable(0));
                    ta.recycle();
                    addcryjimg.setImageResource(R.drawable.baseline_add_24);
                    addcryjtext.setTextColor(requireContext().getColor(R.color.black));
                    cry = false;
                }
            }
        });
        addwm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!wm){
                    addwm.setBackground(requireContext().getDrawable(R.drawable.ripplebrown));
                    addwmimg.setImageResource(R.drawable.baseline_remove_24);
                    addwmtext.setTextColor(requireContext().getColor(R.color.white));
                    wm = true;
                } else {
                    TypedArray ta = requireContext().obtainStyledAttributes(new int[]{androidx.appcompat.R.attr.selectableItemBackground});
                    addwm.setBackground(ta.getDrawable(0));
                    ta.recycle();
                    addwmimg.setImageResource(R.drawable.baseline_add_24);
                    addwmtext.setTextColor(requireContext().getColor(R.color.black));
                    wm = false;
                }
            }
        });
        addpb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!pb){
                    addpb.setBackground(requireContext().getDrawable(R.drawable.ripplebrown));
                    addpbimg.setImageResource(R.drawable.baseline_remove_24);
                    addpbtext.setTextColor(requireContext().getColor(R.color.white));
                    pb = true;
                } else {
                    TypedArray ta = requireContext().obtainStyledAttributes(new int[]{androidx.appcompat.R.attr.selectableItemBackground});
                    addpb.setBackground(ta.getDrawable(0));
                    ta.recycle();
                    addpbimg.setImageResource(R.drawable.baseline_add_24);
                    addpbtext.setTextColor(requireContext().getColor(R.color.black));
                    pb = false;
                }
            }
        });
        Button add = v.findViewById(R.id.addmore);
        Button min = v.findViewById(R.id.minmore);
        Button b = v.findViewById(R.id.sheetbutton);
        switch (type){
            case "1":
                tv.setText(hotdata.get(position).split(":")[1]);
                tvprice.setText("PHP " + hotdata.get(position).split(":")[2]);
                break;
            case "2":
                tv.setText(colddata.get(position).split(":")[1]);
                tvprice.setText("PHP " + colddata.get(position).split(":")[2]);
                break;
            case "3":
                tv.setText(frapcofdata.get(position).split(":")[1]);
                tvprice.setText("PHP " + frapcofdata.get(position).split(":")[2]);
                break;
            case "4":
                tv.setText(frapcredata.get(position).split(":")[1]);
                tvprice.setText("PHP " + frapcredata.get(position).split(":")[2]);
                break;
            case "5":
                tv.setText(mtdata.get(position).split(":")[1]);
                tvprice.setText("PHP " + mtdata.get(position).split(":")[2]);
                break;
            case "6":
                tv.setText(refdata.get(position).split(":")[1]);
                tvprice.setText("PHP " + refdata.get(position).split(":")[2]);
                break;
            case "7":
                tv.setText(snadata.get(position).split(":")[1]);
                tvprice.setText("PHP " + snadata.get(position).split(":")[2]);
                break;
            default:
                break;
        }
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText(String.valueOf(Integer.parseInt(num.getText().toString()) + 1));
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(num.getText().toString()) <= 1){
                    num.setText("1");
                } else {
                    num.setText(String.valueOf(Integer.parseInt(num.getText().toString()) - 1));
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.cancel();
                for (int a = 0; a < Integer.parseInt(num.getText().toString()); a++){
                    cartItems.add(tv.getText() + ":" + tvprice.getText() + ":" + (cof ? "1" : "") + (cry ? "2" : "") + (wm ? "3" : "") + (pb ? "4" : ""));
                }
                cof = false;
                cry = false;
                wm = false;
                pb = false;
                refreshCart();
            }
        });
        bottomSheetDialog.setContentView(v);
        bottomSheetDialog.show();
    }
}