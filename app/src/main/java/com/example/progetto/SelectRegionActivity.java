package com.example.progetto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectRegionActivity extends AppCompatActivity {

    RecyclerView regions_list_view;
    ChipAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_region);

        toolbarConfig();

        chipsConfig();

    }

    private void chipsConfig() {
        regions_list_view = findViewById(R.id.regions_list);

        ArrayList<String> locations = new ArrayList<>();

        for(Locations location: Locations.values()) {
            locations.add(location.getDesc());
        }
        locations.remove(locations.size()-1); // rimuovo l'enum "NONE"

        adapter = new ChipAdapter(locations, new ChipAdapter.OnChipClickListener() {
            @Override public void onChipClick(String item) {
                Toast.makeText(SelectRegionActivity.this, "Item Clicked", Toast.LENGTH_LONG).show();
            }
        });
        regions_list_view.setAdapter(adapter);
    }

    private void toolbarConfig() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.region_toolbar);

        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}