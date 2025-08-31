package com.salazarisaiahnoel.captainscuppos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.salazarisaiahnoel.captainscuppos.R;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {

    List<String> titles;

    public CartAdapter(List<String> titles){
        this.titles = titles;
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
        holder.t.setText(titles.get(holder.getAdapterPosition()).split(";")[0]);
        holder.t1.setText(titles.get(holder.getAdapterPosition()).split(";")[1]);
        holder.t2.setText("PHP " + titles.get(holder.getAdapterPosition()).split(";")[2]);
    }

    public List<String> getOrderAndAmount(){
        List<String> asd = new ArrayList<>();
        for (int a = 0; a < titles.size(); a++){
            asd.add(titles.get(a).split(";")[0] + ";" + titles.get(a).split(";")[1]);
        }
        asd.remove(asd.size() - 1);
        return asd;
    }

    public String getTotal(){
        return "PHP " + titles.get(titles.size() - 1).split(";")[2];
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    class CartHolder extends RecyclerView.ViewHolder {

        TextView t, t1, t2;

        public CartHolder(@NonNull View itemView) {
            super(itemView);

            t = itemView.findViewById(R.id.textView2);
            t1 = itemView.findViewById(R.id.textView3);
            t2 = itemView.findViewById(R.id.textView4);
            t.setSelected(true);
        }
    }
}
