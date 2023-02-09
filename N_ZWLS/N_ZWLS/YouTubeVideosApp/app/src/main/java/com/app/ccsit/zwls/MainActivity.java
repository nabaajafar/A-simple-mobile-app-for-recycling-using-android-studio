package com.app.ccsit.zwls;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;

import com.andremion.floatingnavigationview.FloatingNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private FloatingNavigationView floatingNavigationView;

    RecyclerView recyclerView;
    Vector<YouTubeVideos> youtubeVideos = new Vector<YouTubeVideos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Video Part
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/OasbYWF4_S8\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/6jQ7y_qQYUA\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Jixu9zCF0a0\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/0Xat8b3xGSs&t=24s\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/JofIpJiHp3Q&t=36s\" frameborder=\"0\" allowfullscreen></iframe>"));

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);

        //Menu part

        //HANDLING FLOATING NAVIGATION VIEW EVENTS
        floatingNavigationView = findViewById(R.id.floating_navigation_view);

        floatingNavigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floatingNavigationView.open();
            }
        });


        floatingNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Intent a = null;

                switch (menuItem.getItemId()) {
                    case R.id.navigation_battery:
                        a = new Intent(getBaseContext(),Addpage.class);
                        a.putExtra("title","battery");
                        startActivity(a);
                        return true;
                    case R.id.navigation_bulbs:
                        a = new Intent(getBaseContext(),Addpage.class);
                        a.putExtra("title","bulbs");
                        startActivity(a);
                        return true;
                    case R.id.navigation_ewaste:
                        a = new Intent(getBaseContext(),Addpage.class);
                        a.putExtra("title","ewaste");
                        startActivity(a);
                        return true;
                        case R.id.navigation_glass:
                        a = new Intent(getBaseContext(),Addpage.class);
                        a.putExtra("title","glass");
                            startActivity(a);
                            return true;
                    case R.id.navigation_metal:
                        a = new Intent(getBaseContext(),Addpage.class);
                        a.putExtra("title","metal");

                        startActivity(a);
                        return true;

                    case R.id.navigation_plastic:
                        a = new Intent(getBaseContext(),Addpage.class);
                        a.putExtra("title","plastic");

                        startActivity(a);
                        return true;
                    case R.id.navigation_paper:
                        a = new Intent(getBaseContext(),Addpage.class);
                        a.putExtra("title","paper");
                        startActivity(a);
                        return true;

                    case R.id.navigation_performance:
                        a = new Intent(getBaseContext(),ChartActivity.class);
                        startActivity(a);
                        return true;

                    case R.id.navigation_centers:
                        a = new Intent(getBaseContext(),CentersActivity.class);
                        startActivity(a);
                        return true;
                }

                return true;
            }
        });
    }

    }



