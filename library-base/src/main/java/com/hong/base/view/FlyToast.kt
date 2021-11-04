package com.hong.base.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.hong.base.R


class FlyToast(val context: Context,val content:String,duration:Int) {

    private val toast = Toast(context)
    lateinit var flyToast: FlyToast
    private val v:View =LayoutInflater.from(context).inflate(R.layout.fly_toast,null)
    private val textView:TextView

    init {

        textView = v.findViewById(R.id.textToast)
        textView.text = content
        toast.duration = duration
        toast.view = v

        if (flyToast==null)
            flyToast = FlyToast(context,content,duration)

    }

    fun show(){
        toast.let {
            toast.show()
        }
    }
    fun setGravity(gravity: Int,xOffset:Int, yOffset:Int){
        toast.let {
            it.setGravity(gravity,xOffset,yOffset)
        }
    }
    fun setMessage(message:String){
        textView.text = message
        toast.view = v
    }
}