package com.hong.base.utils

import android.app.Activity

object ActivityManager {
    private val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity){
        activities.add(activity)
    }

    fun removeActivity(activity: Activity){
        activities.remove(activity)
    }

    fun finishAllActivity(){
        for (activity in activities){
            if(!activity.isFinishing)
                activity.finish()
        }
        activities.clear()
    }
}