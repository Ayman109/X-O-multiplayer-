package com.simpleapp.tictoc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> px = new ArrayList<Integer>();
    ArrayList<Integer> po = new ArrayList<Integer>();
    boolean PlX=true;
    boolean PlO=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public int checkWinner(ArrayList<Integer> p){

        if(p.contains(1)&&p.contains(2)&&p.contains(3)) return 1;
        if(p.contains(4)&&p.contains(5)&&p.contains(6)) return 1;
        if(p.contains(7)&&p.contains(8)&&p.contains(9)) return 1;
        if(p.contains(1)&&p.contains(4)&&p.contains(7)) return 1;
        if(p.contains(2)&&p.contains(5)&&p.contains(8)) return 1;
        if(p.contains(3)&&p.contains(6)&&p.contains(9)) return 1;
        if(p.contains(1)&&p.contains(5)&&p.contains(9)) return 1;
        if(p.contains(3)&&p.contains(5)&&p.contains(7)) return 1;
        if(px.size()+po.size()>=9) {
            Replay();
            return 0;
        }
        return -1;

    }

    public void Replay(){
        int[] busid= {R.id.b1, R.id.b2,R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9};
       System.out.println("ok");
       for(int b : busid){
            findViewById(b).setEnabled(true);
           findViewById(b).setBackgroundResource(R.color.gris);
        }
        TextView poscore= findViewById(R.id.pOscore);
        TextView pxscore= findViewById(R.id.pXscore);
        TextView pos = findViewById(R.id.po);
        TextView pxs=findViewById(R.id.px);
        px.clear();
        po.clear();
        if(Integer.parseInt(poscore.getText().toString())>Integer.parseInt(pxscore.getText().toString()))
        {
            pos.setTextColor(Color.parseColor("#3B7DF8"));
            poscore.setTextColor(Color.parseColor("#3B7DF8"));
        }
        if(Integer.parseInt(poscore.getText().toString())<Integer.parseInt(pxscore.getText().toString()))
        {
            pxs.setTextColor(Color.parseColor("#3B7DF8"));
            pxscore.setTextColor(Color.parseColor("#3B7DF8"));
        }
        if(Integer.parseInt(poscore.getText().toString())==Integer.parseInt(pxscore.getText().toString()))
        {
            pxs.setTextColor(Color.parseColor("#888888"));
            pxscore.setTextColor(Color.parseColor("#888888"));
            pos.setTextColor(Color.parseColor("#888888"));
            poscore.setTextColor(Color.parseColor("#888888"));
        }

    }

    public void buclick(View view) {
        int id=0;
        switch (view.getId()){
            case R.id.b1:id=1;break;
            case R.id.b2:id=2;break;
            case R.id.b3:id=3;break;
            case R.id.b4:id=4;break;
            case R.id.b5:id=5;break;
            case R.id.b6:id=6;break;
            case R.id.b7:id=7;break;
            case R.id.b8:id=8;break;
            case R.id.b9:id=9;break;
            default:break;
        }
        findViewById(view.getId()).setEnabled(false);
        if (PlX){
            findViewById(view.getId()).setBackgroundResource(R.drawable.x);
            px.add(id);
            PlX=false;
            PlO=true;

            if (checkWinner(px)==1){
                TextView pxscore= findViewById(R.id.pXscore);
                pxscore.setText(String.valueOf(Integer.parseInt( pxscore.getText().toString())+1));
                PlX=true;
                PlO=false;
                Replay();
            }
        }
        else
        {
            findViewById(view.getId()).setBackgroundResource(R.drawable.o);
            po.add(id);
            PlX=true;
            PlO=false;
            if (checkWinner(po)==1){
                TextView poscore= findViewById(R.id.pOscore);
                poscore.setText(String.valueOf(Integer.parseInt( poscore.getText().toString())+1));
                PlX=false;
                PlO=true;
                Replay();
            }

        }



    }

    public void restart(View view) {
        TextView poscore= findViewById(R.id.pOscore);
        TextView pxscore= findViewById(R.id.pXscore);
        poscore.setText("0");
        pxscore.setText("0");
        Replay();

    }
}