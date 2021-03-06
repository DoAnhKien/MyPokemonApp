package com.example.mypokemonapp.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.adapter.PokemonPagerAdapter;
import com.example.mypokemonapp.databinding.ActivityMainBinding;
import com.example.mypokemonapp.ui.fragments.FavoriteFragment;
import com.example.mypokemonapp.ui.fragments.PokemonFragment;
import com.example.mypokemonapp.ui.getfeedback.GetFeedBackActivity;
import com.example.mypokemonapp.ui.sendreport.SendReportActivity;
import com.example.mypokemonapp.viewmodel.UserPokemonViewModel;
import com.google.android.material.navigation.NavigationView;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityMainBinding binding;
    private UserPokemonViewModel viewModel;
    private static final String TAG = "KienDA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        viewModel = new ViewModelProvider(this).get(UserPokemonViewModel.class);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        binding.vpPokemon.setAdapter(new PokemonPagerAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.vpPokemon);
        binding.navMain.setNavigationItemSelectedListener(this);
        viewModel.getCurrentPokemon().observe(this, pokemon -> {
            Log.d(TAG, "initViews: pokemon: " + pokemon.getPokemonName());
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.mainSearch);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) searchItem.getActionView();
        searchItem.setOnMenuItemClickListener(item -> {
            viewModel.getAllTheUserPokemonFromServer();
            return false;
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                viewModel.getAllTheUserPokemonFromServer();
                if (binding.vpPokemon.getCurrentItem() == 0) {
                    PokemonFragment.adapter.getFilter().filter(newText);
                } else if (binding.vpPokemon.getCurrentItem() == 1) {
                    FavoriteFragment.adapter.getFilter().filter(newText);
                }
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (!binding.drawer.isDrawerOpen(GravityCompat.START)) {
                binding.drawer.openDrawer(GravityCompat.START);
            } else {
                binding.drawer.close();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_list:
                binding.vpPokemon.setCurrentItem(0);
                break;
            case R.id.item_favorite:
                binding.vpPokemon.setCurrentItem(1);
                break;
            case R.id.signOut:
                checkForSignOut();
                break;
            case R.id.item_about:
                break;
            case R.id.sendFeedBack:
                sendReportToAdmin();
                break;
            case R.id.sendReport:
                sendFeedBackToAdmin();
                break;
        }
        binding.drawer.close();
        return false;
    }

    private void sendReportToAdmin(){
        Intent intent = new Intent(this, SendReportActivity.class);
        startActivity(intent);
    }

    private void sendFeedBackToAdmin() {
        Intent intent = new Intent(this, GetFeedBackActivity.class);
        startActivity(intent);
    }

    private void checkForSignOut() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private boolean isTheConnectInternetSuccess() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;
        }
        return false;
    }
}