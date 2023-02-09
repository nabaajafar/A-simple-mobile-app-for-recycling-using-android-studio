package com.app.ccsit.zwls;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class CustomAdapter extends ArrayAdapter<String> {
    private Activity context;
    private String[] countryList;
    private String[] desc;
    private int flags[];

    public CustomAdapter(Activity context, String[] countryList, String[] desc, int flags[]) {
        super(context,R.layout.center_ticket,countryList);
        this.context = context;
        this.desc=desc;
        this.countryList = countryList;
        this.flags = flags;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View r = convertView;
        ViewHolder viewHolder=null;
        if(r==null)
        {
           LayoutInflater layoutInflater=context.getLayoutInflater();
           r=layoutInflater.inflate(R.layout.center_ticket,null,true);
           viewHolder=new ViewHolder(r);
           r.setTag(viewHolder);

        }
        else{
            viewHolder= (ViewHolder) r.getTag();

        }
        viewHolder.ivw.setImageResource(flags[position]);

        viewHolder.tvw1.setText(countryList[position]);

        viewHolder.tvw2.setText(desc[position]);

        return r;

    }
    class ViewHolder
    {
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;
        ViewHolder(View v)
        {
            tvw1=(TextView) v.findViewById(R.id.text);
            tvw2=(TextView) v.findViewById(R.id.tex2);
            ivw=(ImageView) v.findViewById(R.id.imageView);

        }

    }
}
