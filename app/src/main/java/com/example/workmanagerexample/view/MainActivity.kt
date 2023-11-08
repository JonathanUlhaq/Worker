package com.example.workmanagerexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.workmanagerexample.R
import com.example.workmanagerexample.utils.WorkManagerEx
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        worker()
    }


    private fun worker() {

//        Periodic worker repeat 20 menit
//        val request = PeriodicWorkRequestBuilder<WorkManagerEx>(
//            20,
//            TimeUnit.MINUTES)
//            .build()

        //        Ketentuan Worker
//        val constraints = Constraints.Builder()
//            .setRequiresCharging(true)
//            .setRequiresStorageNotLow(true)
//            .build()


//        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
//            "notip",
//            ExistingPeriodicWorkPolicy.KEEP,
//            request,
//        )

//        eksekusi worker satu kali
        val requested = OneTimeWorkRequestBuilder<WorkManagerEx>().build()
        WorkManager.getInstance(this).enqueue(requested)
    }
    fun cancleWorker() {
//        menghentikan periodic worker
        WorkManager.getInstance(this).cancelUniqueWork("notip")
    }
}

