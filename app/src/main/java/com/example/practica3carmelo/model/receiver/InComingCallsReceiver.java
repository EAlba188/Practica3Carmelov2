package com.example.practica3carmelo.model.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

import com.example.practica3carmelo.model.Repository;
import com.example.practica3carmelo.model.entity.Amigo;

public class InComingCallsReceiver extends BroadcastReceiver {

private Repository repos;
private String number;



    @Override
    public void onReceive(Context context, Intent intent) {

        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){

            number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            repos = new Repository(context);
            number =  Amigo.procesaNumero(number);
            repos.getAmigoLlamada(number);

        }
        }
    }
