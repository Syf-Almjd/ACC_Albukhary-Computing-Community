package com.mjd.sci_acc.adopters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mjd.sci_acc.R;

public class MainSocialList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] name;
    private final String[] corpname;
    private final Integer[] imageUrl;
    private final String[] rate;
    private final String[] type;


    public MainSocialList(Activity context, String[] name, String[] corpname, Integer[] imageUrl, String[] rate, String[] type) {
        super(context, R.layout.social_item, name);

        this.context = context;
        this.name = name;
        this.corpname = corpname;
        this.imageUrl = imageUrl;
        this.rate = rate;
        this.type = type;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.social_item, null, true);

        TextView nameText = rowView.findViewById(R.id.name);
        ImageView imageView = rowView.findViewById(R.id.item_image);
        TextView corpText = rowView.findViewById(R.id.corp_name);
        TextView rateText = rowView.findViewById(R.id.rating);
        TextView typeText = rowView.findViewById(R.id.type);
        nameText.setText(name[position]);
        imageView.setImageResource(imageUrl[position]);
        corpText.setText(corpname[position]);
        rateText.setText(rate[position]);
        typeText.setText(type[position]);
        return rowView;
    }

}