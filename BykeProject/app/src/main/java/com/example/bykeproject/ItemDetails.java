package com.example.bykeproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ItemDetails extends AppCompatActivity {
    ImageView imageView;
    Integer[] imageIds={
                R.drawable.fzs,R.drawable.yamahaa,R.drawable.fzs
    };

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        imageView = findViewById(R.id.itemDetailImage);
        Bundle bundle= getIntent().getExtras();
        if(bundle != null) {
            int item = bundle.getInt("item");
            imageView.setImageResource(imageIds[item]);
        }
    }


}
