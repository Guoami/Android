package com.guoami.broadcastbestpractice;

import android.app.Activity;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OBR on 2017/4/13.
 */

public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity:activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
