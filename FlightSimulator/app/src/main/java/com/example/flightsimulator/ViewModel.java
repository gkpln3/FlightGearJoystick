package com.example.flightsimulator;


import android.util.Log;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;

import com.google.android.material.slider.Slider;

public class ViewModel extends BaseObservable implements Joystick.JoystickListener {

    private model model;
//    private int thr;

//    public int getThr() {
////        Log.e("viewmodel",Integer.toString(thr));
//        return (int)(model.getThr()*100);
//    }
//
//    public void setThr(int thr) {
//        Log.e("viewmodel",Integer.toString(thr));
//        model.setThr((double)thr / 100);//in the seekbar its by percents and in the model - its 0 to 1.
//    }


    //    public int getRud() {
////        Log.e("viewmodel",Integer.toString(thr));
//        double rud = model.getRud();
//        rud++;
//        rud = rud /2;
//        rud = rud * 100;
//        return (int)rud;
//    }
//
//    public void setRud(int rud) {
////        Log.e("viewmodel",Integer.toString(rud));
//        double ret = (double) rud /100;
//        ret = ret * 2;
//        ret --;
//        model.setRud(ret);
//    }
    public void onRudValueChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
        int seekBarValue = seekBar.getProgress();
        double ret = (double) seekBarValue /100;
        ret = ret * 2;
        ret --;
        model.setRud(ret);
    }
    public void onThrValueChanged(SeekBar seekBar, int progresValue, boolean fromUser) {

        int seekBarValue = seekBar.getProgress();
        model.setThr((double)seekBarValue / 100);
    }
    public ViewModel(){
        model = model.getInstance();
    }

    public void ipUpdate(CharSequence s) {
        String ip = s.toString();
        model.setIp(ip);
    }
    public void portUpdate(CharSequence s) {

        int port =  Integer.parseInt(s.toString());
        model.setPort(port);
    }
    public void modelConnect() {
        model.connect();
    }

    @Override
    public void onJoystickMoved(float jx, float jy) {
        float aileron = convertRange(jx,394,0,1,-1);
        float elevator = convertRange(jy,394,0,1,-1);
        model.movePlane(aileron,elevator);
    }

    float convertRange(float val,float oldMax,float oldMin,float newMax, float newMin){
        float OldRange = (oldMax - oldMin);
        float NewRange = (newMax - newMin);
        return (((val - oldMin) * NewRange) / OldRange) + (newMin);
    }
}
