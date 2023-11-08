package com.example.workmanagerexample.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.workmanagerexample.R

//Buat class WorkManager
class WorkManagerEx(context: Context, workParam: WorkerParameters) :
    CoroutineWorker(context, workParam) {

    override suspend fun doWork(): Result {

//        Panggil function notification
        notificationGet()
        return Result.success()
    }

    fun notificationGet() {

//        Membuat Notification
        val builder = NotificationCompat.Builder(applicationContext, "190190")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Cek")
            .setContentText("Hooh Tenanan")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("190190", "Channel Name", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }
            notificationManager.notify(1, builder.build())
    }
}