package com.jaysstudio.wordrift;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jaysstudio.wordrift.databinding.ActivityGameBinding;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class GameActivity extends AppCompatActivity {
    ActivityGameBinding binding;
    Timer timer;
    TimerTask timerTask;
    int i = 0;
    Vector<TextView> targets;
    Vocabulary vocabulary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        targets = new Vector<>();
        Intent intent = getIntent();
        vocabulary = intent.getParcelableExtra("vocabulary");

        String s = intent.getStringExtra("message");

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(GameActivity.this, "Value of i : " + vocabulary.count()
                                + "\nmessagge : " +s, Toast.LENGTH_SHORT).show();
                        generateAndAnimate(i++);
                        if (i == vocabulary.count()){
                            timer.cancel();
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask, 1200);
//        generateAndAnimate(0);
    }

    @SuppressLint("ResourceAsColor")
    private void generateAndAnimate(int i) {
        TextView tv = new TextView(getApplicationContext());
        tv.setText(/*vocabulary.getWord(i)*/ "Value of i : " + (i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

//        targets.add(tv);
//        targets.get(i).setLayoutParams(layoutParams);
//        targets.get(i).setLayoutParams(layoutParams);
//        targets.get(i).animate().translationX(900).translationY(100 + targets.get(i).getY()).setDuration(1200);

        tv.setLayoutParams(layoutParams);
        binding.main.addView(tv);
    }
}