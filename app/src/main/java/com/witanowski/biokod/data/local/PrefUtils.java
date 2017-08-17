package com.witanowski.biokod.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Michal Witanowski on 2017-08-17.
 */

public class PrefUtils {

    private static final String token = "token";

    public static void saveToken(Context context, String value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putString(token, value);
        editor.commit();
    }

    public static String getToken(Context context) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            return sharedPrefs.getString(token, "null");
        } catch (Exception e) {
            e.printStackTrace();
            return "null";
        }
    }
}
