package com.example.playing_with_adapters_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class array_adapter_3 extends AppCompatActivity {

    String titles[], description[];
    Integer images[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_3);

        Resources res= getResources();
        titles=res.getStringArray(R.array.titles);
        description=res.getStringArray(R.array.description);

        listView1= findViewById(R.id.listView1);

        CustomArrayAdapter adp= new CustomArrayAdapter(getApplicationContext(),titles,description,images);
        listView1.setAdapter(adp);


    }
}

class CustomArrayAdapter extends ArrayAdapter<String>{

    String titles[];
    String desc[];
    Integer images[];
    Context context;

    public CustomArrayAdapter(@NonNull Context context, String titles[], String desc[], Integer images[] ) {
        super(context,R.layout.row_layout_2,R.id.titleTextView,titles);
        this.context=context;
        this.images=images;
        this.desc=desc;
        this.titles=titles;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=li.inflate(R.layout.row_layout_2,parent,false);

        TextView titleTextView=row.findViewById(R.id.titleTextView);
        TextView descTextView=row.findViewById(R.id.descTestView);
        ImageView imageView=row.findViewById(R.id.imageView);

        titleTextView.setText(titles[position]);
        descTextView.setText(desc[position]);
        imageView.setImageResource(images[position]);

        return row;
    }
}
