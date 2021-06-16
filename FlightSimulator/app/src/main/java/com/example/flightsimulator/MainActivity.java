package com.example.flightsimulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import com.example.flightsimulator.databinding.ActivityMainBinding;
import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("msssyTag", "aaa");
//        setContentView(R.layout.activity_main);
        ViewModel vm = new ViewModel();
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(vm);
        activityMainBinding.executePendingBindings();
        Joystick js = findViewById(R.id.joystick);
        js.addListener(vm);
    }
}