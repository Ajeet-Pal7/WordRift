package com.jaysstudio.wordrift;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jaysstudio.wordrift.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setWordMeaning("Tools","साधन");
        vocabulary.setWordMeaning("Approach","पहुँच");
        vocabulary.setWordMeaning("Appoint","काम में लगाना");
        vocabulary.setWordMeaning("Aqua","जल");
        vocabulary.setWordMeaning("Ardent","उत्सुक");
        vocabulary.setWordMeaning("Abundant","बड़ी मात्रा में");
        vocabulary.setWordMeaning("Acme","उच्च स्तर");
        vocabulary.setWordMeaning("Admonish","डांटना");


        Toast.makeText(this, "conted elements : " + vocabulary.count(), Toast.LENGTH_SHORT).show();

        binding.btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),
                        GameActivity.class)
                        .putExtra("vocabulary",vocabulary)
                        .putExtra("message", "received")
                );
            }
        });
    }

}