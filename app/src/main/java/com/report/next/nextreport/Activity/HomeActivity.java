package com.report.next.nextreport.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.report.next.nextreport.Fragment.HomeFragment;
import com.report.next.nextreport.Fragment.ReportUploadFragment;
import com.report.next.nextreport.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main_menu.jpg
 */

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.ah_nav_view) NavigationView navigationView;
    @BindView(R.id.ah_drawer_layout) DrawerLayout drawer;
    @BindView(R.id.ah_toolbar) Toolbar toolbar;

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    @OnClick(R.id.ah_trigger_bottom_bar)
    public void goToUploadOnClickListener_becauseTheFunctionIsSame() {
        upload();
    }

    @OnClick(R.id.ah_trigger_bottom_button)
    public void upload() {
        this.changeFragment(new ReportUploadFragment(), true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        changeFragment(new HomeFragment(), false);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                HomeActivity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(HomeActivity.this);
    }

    public void changeFragment(Fragment newFragment, boolean isFragmentAddedToBackStack) {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.ah_fragment_container, newFragment);
        if(isFragmentAddedToBackStack) {
            mFragmentTransaction.addToBackStack(null);
        }
        mFragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu_1) {
            // do something
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
