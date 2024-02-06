package com.example.servicelearning

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class Service : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action){
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun start(){
        val notification = NotificationCompat.Builder(this,"Running_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("ServiceLearning")
            .setContentText("Test of Service Learning")
            .build()

        startForeground(1,notification)
    }

    enum class Actions{
        START,STOP
    }
}