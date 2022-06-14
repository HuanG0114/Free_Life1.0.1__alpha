package com.example.bottomnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class My_Gallery extends AppCompatActivity {
    ImageView picture;
    Button add, next, back;
    public static int PICK_IMAGE = 1;
    ArrayList<Uri> uriLIst = new ArrayList<>();
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_gallery);

        picture=(ImageView)findViewById(R.id.imageView);
        add=(Button)findViewById(R.id.btnAdd);
        next=(Button)findViewById(R.id.btnNext);
        back=(Button)findViewById(R.id.btnBack);

        add.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setType("*/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Choose"), PICK_IMAGE);
        });
        next.setOnClickListener(view -> {
            for (int i = 0; i<uriLIst.size(); i++){
                position = i;
                picture.setImageURI(uriLIst.get(position));
            }
        });
    }
}