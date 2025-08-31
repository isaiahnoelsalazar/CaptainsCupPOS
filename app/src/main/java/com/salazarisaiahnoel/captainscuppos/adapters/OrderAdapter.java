package com.salazarisaiahnoel.captainscuppos.adapters;

import static com.salazarisaiahnoel.captainscuppos.fragments.OrderFragment.remove;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.salazarisaiahnoel.captainscuppos.Cart;
import com.salazarisaiahnoel.captainscuppos.R;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder> {

    Context context;
    List<String> titles;

    public OrderAdapter(Context context, List<String> titles){
        this.context = context;
        this.titles = titles;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new OrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        holder.t.setText(titles.get(holder.getAdapterPosition()).split(";")[0] + "\n\n" + titles.get(holder.getAdapterPosition()).split(";")[3]);
        holder.t1.setText(titles.get(holder.getAdapterPosition()).split(";")[2]);
        holder.t2.setText("Barista " + titles.get(holder.getAdapterPosition()).split(";")[1]);
        holder.order.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View dialogView = layoutInflater.inflate(R.layout.rounded_alert_dialog_layout, null);
                final TextView texttitle = dialogView.findViewById(R.id.rounded_alert_dialog_title);
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setView(dialogView);
                AlertDialog alertDialog = builder.create();
                Objects.requireNonNull(alertDialog.getWindow()).getDecorView().setBackgroundColor(Color.TRANSPARENT);
                texttitle.setText("Delete order?");
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
                        remove(titles.get(holder.getAdapterPosition()).split(";")[0] + "~" + titles.get(holder.getAdapterPosition()).split(";")[1] + "~" + titles.get(holder.getAdapterPosition()).split(";")[2] + "~" + titles.get(holder.getAdapterPosition()).split(";")[3]);
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    class OrderHolder extends RecyclerView.ViewHolder {

        TextView t, t1, t2;
        ConstraintLayout order;

        public OrderHolder(@NonNull View itemView) {
            super(itemView);

            t = itemView.findViewById(R.id.textView2);
            t1 = itemView.findViewById(R.id.textView3);
            t2 = itemView.findViewById(R.id.textView4);
            order = itemView.findViewById(R.id.orderqwertyuiop);
            t.setSelected(true);
        }
    }
}
