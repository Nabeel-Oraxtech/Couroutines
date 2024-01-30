package com.example.couroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    var TAG="Thread Tag"
    lateinit var text:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         text=findViewById(R.id.tv)
        Log.d(TAG,"${Thread.currentThread().name}")
        CoroutineScope(Dispatchers.Main).launch{
            task1()
        }
        CoroutineScope(Dispatchers.Main).launch{
            task2()
        }
    }
//    fun update(view: View){
//        Log.d(TAG,"${Thread.currentThread().name}")
//        text.text="${text.text.toString().toInt()+1}"
//    }
//    fun executeLongRunningTAsk(){
//        for (i in 1..10000000000L){
//
//        }
//    }
//    fun doAction(view: View){
//        CoroutineScope(Dispatchers.IO).launch {
//            Log.d(TAG,"1-${Thread.currentThread().name}")
//        }
//        GlobalScope.launch( Dispatchers.Main ){
//            Log.d(TAG,"2-${Thread.currentThread().name}")
//        }
//        MainScope().launch ( Dispatchers.Default ){
//            Log.d(TAG,"3-${Thread.currentThread().name}")
//        }
//    }
    suspend fun task1(){
    Log.d(TAG,"Starting 1")
    yield()
    Log.d(TAG,"Ending 1")
    }
    suspend fun task2(){
        Log.d(TAG,"Starting 2")
        delay(2000)
        Log.d(TAG,"Ending 2")
    }
}