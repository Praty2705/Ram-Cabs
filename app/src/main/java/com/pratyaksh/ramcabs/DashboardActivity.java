package com.pratyaksh.ramcabs;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.material.navigation.NavigationView;
import com.pratyaksh.ramcabs.fragemnt.AboutUsFragment;
import com.pratyaksh.ramcabs.fragemnt.DashboardFragment;
import com.pratyaksh.ramcabs.fragemnt.FaqFragment;
import com.pratyaksh.ramcabs.fragemnt.ProfileFragment;
import com.pratyaksh.ramcabs.fragemnt.ReferFragment;
import com.pratyaksh.ramcabs.fragemnt.SupportFragment;
import com.pratyaksh.ramcabs.fragemnt.WalletFragment;
import com.pratyaksh.ramcabs.fragemnt.YourbookingFragment;

import java.util.Arrays;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Loader loader;
    Context context;
    FragmentManager fm;
    private static final String apiKey ="AIzaSyB5RgWeIPEgqbehm9BaGZeBHN5jxe-GR4M";
    private static final int AUTOCOMPLETE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        context = DashboardActivity.this;
        loader = new Loader(DashboardActivity.this);

     //   loader.hideLottieDialog();



/*

        // Initialize the SDK
        Places.initialize(getApplicationContext(), apiKey);

        // Create a new PlacesClient instance
        PlacesClient placesClient = Places.createClient(this);

        // Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        // Specify the types of place data to return.
        assert autocompleteFragment != null;
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());
            }


            @Override
            public void onError(@NonNull Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });
        // Set the fields to specify which types of place data to
        // return after the user has made a selection.
        List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME);

        // Start the autocomplete intent.
        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                .build(this);
        startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE);



*/

        Toolbar toolbar = findViewById(R.id.toolbar);
        nav = findViewById(R.id.nav_view);


        drawerLayout = findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

       getSupportFragmentManager().beginTransaction().replace(R.id.dashboardFragment,new DashboardFragment(getApplicationContext(),getSupportFragmentManager())).commit();
        Log.d("asdf","DFragmentloaded");

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment temp ;
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.Mehome:
                        Log.d("asdf","home clicked");
                        //getSupportFragmentManager().beginTransaction().replace(R.id.dashboardFragment,new DashboardFragment(context,getSupportFragmentManager())).commit();
                     //   loader.showLottieDialog();
//                        getSupportFragmentManager().beginTransaction().replace(R.id.dashboardFragment,new DashboardFragment(getApplicationContext(),getSupportFragmentManager())).commit();
                        startActivity(new Intent(context,DashboardActivity.class));
                        return true;
//                        break;
                    case R.id.Meprofile:
                        temp = new ProfileFragment(context);
                        break;
                    case R.id.Mewallet:
                        temp = new WalletFragment();
                        break;
                    case R.id.Mebooking:
                        temp = new YourbookingFragment();
                        break;
                    case R.id.Merefer:
                        temp = new ReferFragment();
                        break;
                    case R.id.Mesupport:
                        temp= new SupportFragment(context,getSupportFragmentManager());
                        break;
                    case R.id.Meaboutus:
                        temp= new AboutUsFragment();
                        break;
                    case R.id.Mefaq:
                        temp= new FaqFragment();
                         break;
                    case R.id.Melogout:
                            processlogout();
                            break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.dashboardFragment,temp).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        
    }

    private void processlogout() {
       // loader.showLottieDialog();
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }

  /*  @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = Autocomplete.getPlaceFromIntent(data);
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());
            } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                // TODO: Handle the error.
                Status status = Autocomplete.getStatusFromIntent(data);
                Log.i(TAG, status.getStatusMessage());
            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
*/

}