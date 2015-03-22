package com.lorentzos.swipecards;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ayhan on 22/03/15.
 */
public class OptionAdapter extends ArrayAdapter<RedOrBlue> {
    Context context;
    int layoutResourceId;
    List<RedOrBlue> objects = null;

    public OptionAdapter(Context context, int resource, List<RedOrBlue> objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.layoutResourceId = resource;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        OptionHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new OptionHolder();
            holder.img1Icon = (ImageView)row.findViewById(R.id.img1Icon);
            holder.img1Icon = (ImageView)row.findViewById(R.id.img2Icon);
            holder.txt1Title = (TextView)row.findViewById(R.id.txt1Title);
            holder.txt2Title = (TextView)row.findViewById(R.id.txt2Title);

            row.setTag(holder);
        }
        else
        {
            holder = (OptionHolder)row.getTag();
        }

        RedOrBlue option = objects.get(position);
        holder.txt1Title.setText(option.RedTitle);
        holder.txt2Title.setText(option.BlueTitle);
        //holder.imgIcon.setImageResource(weather.icon);

        return row;
    }

    static class OptionHolder
    {
        ImageView img1Icon;
        ImageView img2Icon;
        TextView txt1Title;
        TextView txt2Title;
    }
}
