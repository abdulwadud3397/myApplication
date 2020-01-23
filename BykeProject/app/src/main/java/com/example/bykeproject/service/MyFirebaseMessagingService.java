package com.example.bykeproject.service;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    final  static  String msg = "firebase";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
//        super.onMessageReceived(remoteMessage);
        Log.d(msg, "Message------>"+remoteMessage.getNotification().getBody());
       // startActivity(new Intent(getBaseContext(),NavigationActi));

    }
}
