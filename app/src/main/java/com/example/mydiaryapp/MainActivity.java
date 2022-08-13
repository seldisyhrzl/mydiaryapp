package com.example.mydiaryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.example.mydiaryapp.databinding.ActivityMainBinding;
import com.example.mydiaryapp.fragment.AboutFragment;
import com.example.mydiaryapp.fragment.NoteFragment;
import com.example.mydiaryapp.fragment.ProfileFragment;
import com.example.mydiaryapp.fragment.SettingFragment;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//10119086_SeldiSyahrizal_IF3
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new ProfileFragment());

        binding.navigationMenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.profile:
                        replaceFragment(new ProfileFragment());
                        break;
                    case R.id.note:
                        replaceFragment(new NoteFragment());
                        break;
                    case R.id.about:
                        replaceFragment(new AboutFragment());
                        break;
                    case R.id.setting:
                        replaceFragment(new SettingFragment());
                        break;
                }
                return true;
            }
        });
    }

    private void replaceFragment (Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }




}