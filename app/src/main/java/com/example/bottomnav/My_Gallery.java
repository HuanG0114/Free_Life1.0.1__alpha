package com.example.bottomnav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
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

        picture=(ImageView)findViewById(R.id.imageView1);
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
        back.setOnClickListener(view -> {
            for (int i = uriLIst.size()-1; i>0; i--){
                position = i;
                picture.setImageURI(uriLIst.get(position));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE) {
            if (data != null) {
                Uri imageURi = data.getData();
                uriLIst.add(imageURi);
                picture.setImageURI(uriLIst.get(position));
            }
        }
    }
}