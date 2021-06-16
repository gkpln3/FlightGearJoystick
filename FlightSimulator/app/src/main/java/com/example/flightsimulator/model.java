package com.example.flightsimulator;

import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class model {
    private static model instance = null;
    private String Ip ;
    private int port;
    private Socket fg;
//    private double thr;
//    private double rud;
    private ExecutorService executor;
    private  PrintWriter out;

    private model(){
        port = -1;
        Ip = "";
        fg = null;
//        thr = -1;
//        rud = -1;
        executor = null;
        out = null;
    }
    public static model getInstance()
    {
        if (instance == null)
            instance = new model();

        return instance;
    }

    public void setIp(String ip) { this.Ip = ip; }
    public String getIp() {
        return Ip;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public int getPort() {
        return port;
    }
    public void setThr(double th) {
//        this.thr = th;

        if(executor!= null && out!= null) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    out.print("set /controls/engines/current-engine/throttle " + Double.toString(th) + "\r\n");
                    out.flush();
                }
            });
        }

        Log.e("model",Double.toString(th));
    }
//    public double getThr() {
//        Log.e("model",Double.toString(thr));
//        return thr;
//    }
    public void setRud(double ru) {
//        this.rud = ru;
        if(executor!= null && out!= null) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
//                    out.print("run nasal aircraft.systems.autostart");
                    out.print("set /controls/flight/rudder " + Double.toString(ru) + "\r\n");
                    out.flush();
                }
            });
        }
        Log.e("model",Double.toString(ru));
    }
//    public double getRud() {
//        Log.e("model",Double.toString(rud));
//
//        return rud;
//    }

    public void connect() {
        Log.d("modelip",Ip);
        Log.d("modelport",Integer.toString(port));
        executor = Executors.newFixedThreadPool(1);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("model","Connecting");
                    fg = new Socket(Ip,port);
                    if(fg.isConnected())
                        Log.d("model","Conneכed");
                    out = new PrintWriter(fg.getOutputStream(),true);

                }
                catch (Exception e ){
                    Log.d("model","Connection Error");
                    Log.d("model",e.toString());
                }
            }
        });

    }


    public void movePlane(float aileron, float elevator) {
        if(executor!= null && out!= null) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    out.print("set /controls/flight/aileron " + Double.toString(aileron) + "\r\n");
                    out.flush();
                    out.print("set /controls/flight/elevator " + Double.toString(elevator) + "\r\n");
                    out.flush();
                }
            });
        }


    }

}
