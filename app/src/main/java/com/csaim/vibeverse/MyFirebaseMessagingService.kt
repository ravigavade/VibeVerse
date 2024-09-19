package com.csaim.vibeverse

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Telephony.Mms.Intents
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channelId="notication_channel"
const val channelName="com.csaim.fcm"

class MyFirebaseMessagingService: FirebaseMessagingService() {

    //generate the notification
    //attach the notification created with the custom layout
    //show the notification

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if(remoteMessage.getNotification()!=null){
            generateNotification(remoteMessage.notification!!.title!!,remoteMessage.notification!!.body!!)
        }
    }

    @SuppressLint("RemoteViewLayout")
    private fun getRemoteView(title: String, message: String): RemoteViews? {
        val remoteView=RemoteViews("com.csaim.fcm",R.layout.notification)

        remoteView.setTextViewText(R.id.title,title)
        remoteView.setTextViewText(R.id.message,message)
        remoteView.setImageViewResource(R.id.app_logo,R.drawable.ic_launcher_foreground)
        return remoteView
    }

    //fun for generation notification
    @RequiresApi(Build.VERSION_CODES.O)
    fun generateNotification(title:String, message:String){

        val intent= Intent(this,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent=PendingIntent.getActivity(this,0,intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)

        //channel id, channel name
        var builder:NotificationCompat.Builder=NotificationCompat.Builder(applicationContext,
            channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)

        builder=builder.setContent(getRemoteView(title,message))


        //create notificatio manager
        val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(0,builder.build())


    }



}