package com.mjd.sci_acc.adopters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mjd.sci_acc.Events.AnntemsList;
import com.mjd.sci_acc.R;

import java.util.List;

public class AnnAdapter extends RecyclerView.Adapter<AnnAdapter.DiscountedProductViewHolder> {

    Context context;
    List<AnntemsList> AnntemsListRecycle;

    public AnnAdapter(Context context, List<AnntemsList> AnntemsListRecycle) {
        this.context = context;
        this.AnntemsListRecycle = AnntemsListRecycle;
    }

    @NonNull
    @Override
    public DiscountedProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.ann_items, parent, false);
        return new DiscountedProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountedProductViewHolder holder, int position) {

        holder.AnnImage.setImageResource(AnntemsListRecycle.get(position).getImageurl());

    }

    @Override
    public int getItemCount() {
        return AnntemsListRecycle.size();
    }

    public static class DiscountedProductViewHolder extends RecyclerView.ViewHolder {

        ImageView AnnImage;

        public DiscountedProductViewHolder(@NonNull View itemView) {
            super(itemView);

            AnnImage = itemView.findViewById(R.id.AnnImage);

        }

    }

}