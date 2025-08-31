package com.salazarisaiahnoel.captainscuppos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.salazarisaiahnoel.captainscuppos.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {

    List<String> titles;
    OnItemClickListener listener;

    public HomeAdapter(List<String> titles, OnItemClickListener listener){
        this.titles = titles;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
        return new HomeHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        holder.t.setText(titles.get(holder.getAdapterPosition()).split(":")[1]);
        holder.t1.setText(titles.get(holder.getAdapterPosition()).split(":")[0]);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public interface OnItemClickListener{
        void onItemClick(int position, String type);
    }

    class HomeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView t, t1;
        OnItemClickListener listener;

        public HomeHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            t = itemView.findViewById(R.id.itemt);
            t1 = itemView.findViewById(R.id.cctype);
            t.setSelected(true);

            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition(), t1.getText().toString());
        }
    }
}
