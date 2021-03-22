package com.example.fruitcart;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    MediaPlayer music;
    Button btnsubmit;
    RatingBar rate;
    TextView tvtt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btnsubmit=findViewById(R.id.btnsubmit);
        rate=(RatingBar)findViewById(R.id.rtbar);
        tvtt=findViewById(R.id.tvtt2);
        music=MediaPlayer.create(this,R.raw.music);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    final float rating = rate.getRating();
                    if(rating == 0.0){
                        Toast.makeText(getApplicationContext(),"Please Rate the Application ",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        tvtt.setText("Thanks For Rating : " + rating);
                        music.start();
                    }
            }
        });
    }
}
