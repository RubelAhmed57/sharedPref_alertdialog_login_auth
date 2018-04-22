package com.example.rubel.teammate;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by rubel on 4/18/18.
 */

public class utils {
    /****** Shared Preference ******/
    private static final String PREFS_NAME = "storage_name";
// set
    public static void savePreference(Context context, String key, String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.apply();
    }

    // get
    public static String getPreference(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        return prefs.getString(key, null);
    }

/*******************************/
}
