package com.example.game;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    ImageView Img0,Img1,Img2,Img3,Img4,Img5,Img6,Img7,Img8,Img9;

    TextView textView_Time;
    int leftTime;
    MediaPlayer mediaPlayer;

    Handler handler = new Handler();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mediaPlayer = MediaPlayer.create(this,R.raw.wood);
        textView_Time = findViewById(R.id.Txv_Time);
        Img1 = findViewById(R.id.Img_number1);
        Img2 = findViewById(R.id.Img_number2);
        Img3 = findViewById(R.id.Img_number3);
        Img4 = findViewById(R.id.Img_number4);
        Img5 = findViewById(R.id.Img_number5);
        Img6 = findViewById(R.id.Img_number6);
        Img7 = findViewById(R.id.Img_number7);
        Img8 = findViewById(R.id.Img_number8);
        Img9 = findViewById(R.id.Img_number9);
        Img0 = findViewById(R.id.Img_number0);


        Randomize();

        Img0.setOnClickListener(button_Click);
        Img1.setOnClickListener(button_Click);
        Img2.setOnClickListener(button_Click);
        Img3.setOnClickListener(button_Click);
        Img4.setOnClickListener(button_Click);
        Img5.setOnClickListener(button_Click);
        Img6.setOnClickListener(button_Click);
        Img7.setOnClickListener(button_Click);
        Img8.setOnClickListener(button_Click);
        Img9.setOnClickListener(button_Click);

        timer.run();
    }

    Runnable timer = new Runnable() {
        @Override
        public void run() {
            leftTime++;
            textView_Time.setText(leftTime + "");

            handler.postDelayed(this,1000);

        }
    };


    View.OnClickListener button_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mediaPlayer.start();
            relocateButton((ImageView) view);
            if(isPuzzleCompleted()){
                handler.removeCallbacksAndMessages(null);
                 Toast.makeText(MainActivity.this, "Puzzle is completed", Toast.LENGTH_SHORT).show();
            }
        }
    };



    void Randomize(){


        ArrayList<Integer> listImg = new ArrayList<>();

        listImg.add(1);
        listImg.add(2);
        listImg.add(3);
        listImg.add(4);
        listImg.add(5);
        listImg.add(6);
        listImg.add(7);
        listImg.add(8);
        listImg.add(9);


        Collections.shuffle(listImg);

        int currentNo;

        for(int i =0; i <listImg.size();i++){

            currentNo = listImg.get(i);


            if(i == 0 ) {
                Img1.setImageResource(getRes(currentNo));
                Img1.setTag(currentNo);
            }
            if(i == 1 ) {
                Img2.setImageResource(getRes(currentNo));
                Img2.setTag(currentNo);
            }
            if(i == 2 ) {
                Img3.setImageResource(getRes(currentNo));
                Img3.setTag(currentNo);
            }
            if(i == 3 ) {
                Img4.setImageResource(getRes(currentNo));
                Img4.setTag(currentNo);
            }
            if(i == 4 ) {
                Img5.setImageResource(getRes(currentNo));
                Img5.setTag(currentNo);
            }
            if(i == 5 ) {
                Img6.setImageResource(getRes(currentNo));
                Img6.setTag(currentNo);
            }
            if(i == 6 ) {
                Img7.setImageResource(getRes(currentNo));
                Img7.setTag(currentNo);
            }
            if(i == 7 ) {
                Img8.setImageResource(getRes(currentNo));
                Img8.setTag(currentNo);
            }
            if(i == 8 ) {
                Img9.setImageResource(getRes(currentNo));
                Img9.setTag(currentNo);
            }

            Img0.setTag(0);
        }
    }



      int getRes(int Img){

        if(Img == 1){
            return R.mipmap.pngtree_one;
        }

        if(Img == 2){
            return R.mipmap.pngtree_two;
        }

        if(Img == 3){
            return R.mipmap.pngtree_three;
        }

        if(Img == 4){
            return R.mipmap.pngtree_four;
        }

        if(Img == 5){
            return R.mipmap.pngtree_five;
        }

        if(Img == 6){
            return R.mipmap.pngtree_six;
        }

        if(Img == 7){
            return R.mipmap.pngtree_seven;
        }

        if(Img == 8){
            return R.mipmap.pngtree_eight;
        }

        if(Img == 9){
            return R.mipmap.pngtree_nine;
        }

        return 0;
    }

    void relocateButton(ImageView view){

         int tag = (Integer) view.getTag();

         int imageResource = getRes(tag);

         getEmptyButton().setImageResource(imageResource);

         getEmptyButton().setTag(tag);

         view.setImageResource(R.mipmap.blank);

         view.setTag(0);

    }

    ImageView getEmptyButton(){

         if((Integer) Img1.getTag() == 0) return Img1;

         if((Integer) Img2.getTag() == 0) return Img2;

         if((Integer) Img3.getTag() == 0) return Img3;

         if((Integer) Img4.getTag() == 0) return Img4;

         if((Integer) Img5.getTag() == 0) return Img5;

         if((Integer) Img6.getTag() == 0) return Img6;

         if((Integer) Img7.getTag() == 0) return Img7;

         if((Integer) Img8.getTag() == 0) return Img8;

         if((Integer) Img9.getTag() == 0) return Img9;

         return Img0;
    }

    boolean isPuzzleCompleted(){
        if((Integer) Img1.getTag() != 1) return false;
        if((Integer) Img2.getTag() != 2) return false;
        if((Integer) Img3.getTag() != 3) return false;
        if((Integer) Img4.getTag() != 4) return false;
        if((Integer) Img5.getTag() != 5) return false;
        if((Integer) Img6.getTag() != 6) return false;
        if((Integer) Img7.getTag() != 7) return false;
        if((Integer) Img8.getTag() != 8) return false;
        if((Integer) Img9.getTag() != 9) return false;
        return true;
    }

}