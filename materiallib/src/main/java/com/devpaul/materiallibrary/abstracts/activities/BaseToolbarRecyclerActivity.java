package com.devpaul.materiallibrary.abstracts.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.devpaul.materialfabmenu.R;

/**
 * Created by Paul on 10/11/2015.
 */
public abstract class BaseToolbarRecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private Toolbar toolbar;

    private FrameLayout homeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_library_base_toolbar_activity);
        toolbar = (Toolbar) findViewById(R.id.material_library_base_toolbar);
        setSupportActionBar(toolbar);
        homeLayout = (FrameLayout) findViewById(R.id.material_library_base_activity_content);
        recyclerView = new RecyclerView(this);
        recyclerView.setId(R.id.material_library_recycler_view);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        recyclerView.setLayoutParams(params);
        homeLayout.addView(recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(getLayoutManager());
        init();
    }

    /**
     * This is where you should initialize all your views and anything else you need.
     */
    public abstract void init();

    /**
     * Returns a layout manager for the RecylerView
     * @return a layout manager, should not be null.
     */
    public abstract @NonNull RecyclerView.LayoutManager getLayoutManager();

    public FrameLayout getHomeLayout() {
        return this.homeLayout;
    }

    public Toolbar getToolbar() {
        return this.toolbar;
    }

    public RecyclerView getRecyclerView() {
        return this.recyclerView;
    }
}
