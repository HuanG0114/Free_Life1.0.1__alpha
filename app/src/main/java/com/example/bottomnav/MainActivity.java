package com.example.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView,bottomNavigationView2;
    ActionBarDrawerToggle drawerToggle;
    Dialog popAddPost; //對話方塊
    NavigationView navigationView;



    ImageView picture;
    Button add, next, back;
    public static int PICK_IMAGE = 1;
    ArrayList<Uri> uriLIst = new ArrayList<>();
    int position = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //刪除final
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        //Assign wariable


        //int
        //ini popup
        intPopup();

        //側邊選單相簿功能
        navigationView =(NavigationView) findViewById(R.id.drawer_ad) ;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.photo:
                        Intent intent = new Intent(MainActivity.this,My_Gallery.class);
                        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                        startActivity(intent);
                        return true;

                    case R.id.home_drawer:
                        Intent intent1 = new Intent(MainActivity.this,My_page.class);
                        startActivity(intent1);
                        return true;

                    case R.id.book:
                        Intent intent2 = new Intent(MainActivity.this,bolg_post.class);
                        startActivity(intent2);
                        return true;


                }

                return false;
            }
        });





        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.home_btn);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab) ;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popAddPost.show();
            }
        });




        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case  R.id.home_btn:

                        return  true;

                    case R.id.book_btn:
                        startActivity(new Intent(getApplicationContext(),Publish_page.class));
                        overridePendingTransition(0,0);
                        return true;





                    case R.id.notify_btn:
                        startActivity(new Intent(getApplicationContext(), notification_page.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.My_btn:
                        startActivity(new Intent(getApplicationContext(), My_page.class));
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });

    }
    //popu
    private void intPopup() {
        popAddPost = new Dialog(this); //最後
        popAddPost.setContentView(R.layout.popup_add_post);
        popAddPost.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popAddPost.getWindow().setLayout(Toolbar.LayoutParams.MATCH_PARENT,Toolbar.LayoutParams.WRAP_CONTENT);
        popAddPost.getWindow().getAttributes().gravity = Gravity.TOP;

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }


    public void ClickMenu(View view) {
        openLayout(drawerLayout);
    }

    private void openLayout(DrawerLayout drawerLayout) {

    }
}