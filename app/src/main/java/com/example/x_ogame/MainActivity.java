package com.example.x_ogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int active_person=0;
    int default_place[]={2,2,2,2,2,2,2,2,2};
    int win[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void point_tap(View view)
    {
        ImageView a=(ImageView)view;
        int id=Integer.parseInt(a.getTag().toString());
        if(default_place[id]==2)
        {
            if(active_person==0)
            {
                a.setImageResource(R.drawable.x);
                active_person=1;
                default_place[id]=0;
            }
            else
            {
                a.setImageResource(R.drawable.o);
                active_person=0;
                default_place[id]=1;
            }
        }
        for(int i=0;i<win.length;i++)
        {
            if(default_place[win[i][0]]==default_place[win[i][1]]&&default_place[win[i][0]]==default_place[win[i][2]]&&default_place[win[i][0]]!=2)
            {
                if(default_place[win[i][0]]==0)
                    Toast.makeText(this, "X Wins", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "O Wins", Toast.LENGTH_SHORT).show();
                reset(view);
            }
        }
    }
    public void reset(View view)
    {
        active_person=0;
        for(int i=0;i<default_place.length;i++)
            default_place[i]=2;
        ((ImageView)findViewById(R.id.i0)).setImageResource(0);
        ((ImageView)findViewById(R.id.i1)).setImageResource(0);
        ((ImageView)findViewById(R.id.i2)).setImageResource(0);
        ((ImageView)findViewById(R.id.i3)).setImageResource(0);
        ((ImageView)findViewById(R.id.i4)).setImageResource(0);
        ((ImageView)findViewById(R.id.i5)).setImageResource(0);
        ((ImageView)findViewById(R.id.i6)).setImageResource(0);
        ((ImageView)findViewById(R.id.i7)).setImageResource(0);
        ((ImageView)findViewById(R.id.i8)).setImageResource(0);
    }
}
