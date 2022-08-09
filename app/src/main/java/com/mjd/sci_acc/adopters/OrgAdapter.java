package com.mjd.sci_acc.adopters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mjd.sci_acc.Events.OrgItemsList;
import com.mjd.sci_acc.R;

import java.util.List;

public class OrgAdapter extends RecyclerView.Adapter<OrgAdapter.DiscountedProductViewHolder> {

    Context context;
    List<OrgItemsList> OrgList;

    public OrgAdapter(Context context, List<OrgItemsList> OrgList) {
        this.context = context;
        this.OrgList = OrgList;
    }

    @NonNull
    @Override
    public DiscountedProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.org_items, parent, false);
        return new DiscountedProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountedProductViewHolder holder, int position) {

        holder.OrgImageView.setImageResource(OrgList.get(position).getImageurl());

    }

    @Override
    public int getItemCount() {
        return OrgList.size();
    }

    public static class DiscountedProductViewHolder extends RecyclerView.ViewHolder {

        ImageView OrgImageView;

        public DiscountedProductViewHolder(@NonNull View itemView) {
            super(itemView);

            OrgImageView = itemView.findViewById(R.id.OrgItems);

        }
    }
}
