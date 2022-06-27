package br.com.senac.fragmentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    LibraryFragment libraryFragment = new LibraryFragment();
    ExploreFragment exploreFragment = new ExploreFragment();
    SubscriptionsFragment subscriptionsFragment = new SubscriptionsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.idBottomNavView);

        getSupportFragmentManager().beginTransaction().replace(R.id.idContainer, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.menuHome:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.idContainer, homeFragment).commit();
                        break;
                    case R.id.menuExplore:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.idContainer, exploreFragment).commit();
                        break;
                    case R.id.menuSubscriptions:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.idContainer, subscriptionsFragment).commit();
                        break;
                    case R.id.menuLibrary:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.idContainer, libraryFragment).commit();
                        break;

                }
                return false;
            }
        });


    }
}