package com.example.playing_with_adapters_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class array_adapter_4 extends AppCompatActivity {

    String titles[];
    Integer images[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
            R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_4);
        gridView=findViewById(R.id.gridView);

        Resources res=getResources();
        titles=res.getStringArray(R.array.titles);

        myAdapter adp= new myAdapter(getApplicationContext(),titles,images);
        gridView.setAdapter(adp);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),titles[position]+" selected",Toast.LENGTH_SHORT).show();
            }
        });


    }
}

class myAdapter extends BaseAdapter {

    Context context;
    ArrayList<HashMap<String,String>> data; //I am using hash maps here.

    public myAdapter(Context context, String titles[], Integer images[]){

//        Allocating memory to array list.
        data=new ArrayList<HashMap<String, String>>();

//        referencing context.
        this.context=context;

//        Populating the array list of hash maps;
        for (int i=0; i<titles.length;i++){
            HashMap<String,String> temp= new HashMap<String,String>();
            temp.put("Title",titles[i]);
            temp.put("Image",images[i]+"");
            data.add(temp);
        }
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View element =convertView;
        myViewHolder holder=null;

        if (element==null){
            //        Getting the layout
            LayoutInflater li= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            element=li.inflate(R.layout.grid_layout_1,parent,false);

        // Storing the tags of element in the view holder object.
        holder = new myViewHolder(element);
        element.setTag(holder);
        }
        else{
            holder= (myViewHolder) element.getTag();
        }
        HashMap<String,String> temp= new HashMap<String,String>();
        temp=data.get(position);
        holder.textView.setText(temp.get("Title"));
        holder.imageView.setImageResource(Integer.parseInt(temp.get("Image")));
        return element;

    }
}


class myViewHolder{
    ImageView imageView;
    TextView textView;

    public myViewHolder(View v){
        imageView=v.findViewById(R.id.imageView);
        textView=v.findViewById(R.id.textView);
    }
}