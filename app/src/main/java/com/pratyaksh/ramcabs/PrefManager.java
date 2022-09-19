package com.pratyaksh.ramcabs;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    private static PrefManager instance;
    private static final String PREF_NAME = "RamCabs";
    private final SharedPreferences preferences;
    private final SharedPreferences.Editor editor;
    private static final String KEY_REMEMBER_ME = "remember_me";
    private static final String KEY_IS_LOGGED_IN = "is_Login";
    private static final String KEY_IS_OLD_USER= "is_First_Time";
    private static final String KEY_USER_DETAILS = "user";




    private Context context;
    int PRIVATE_MODE = 0;

    public PrefManager(Context context) {


        this.context = context;
        preferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }


    public static PrefManager getInstance(Context context) {
        if (instance == null) {
            instance = new PrefManager(context);
        }
        return instance;
    }

    public void setKeyIsLoggedIn(boolean value) {
        setBooleanValue(KEY_IS_LOGGED_IN, value);
    }

    public boolean getKeyIsLoggedIn() {
        return getBooleanValue(KEY_IS_LOGGED_IN);
    }

    public void setKeyRememberMe(boolean value) {
        setBooleanValue(KEY_REMEMBER_ME, value);
    }

    public boolean getKeyRememberMe() {
        return getBooleanValue(KEY_REMEMBER_ME);
    }


    public void setKeyIsOldUser(boolean value) {
        setBooleanValue(KEY_IS_OLD_USER, value);
    }

    public boolean getKeyIsOldusere() {
        return getBooleanValue(KEY_IS_OLD_USER);
    }



/*

    public UserDetails getUserDetail() {
        Gson gson = new Gson();
        String json = preferences.getString(KEY_USER_DETAILS, "");
        return gson.fromJson(json, UserDetails.class);
    }

    public void setUserDetail(UserDetails user) {
        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putString(KEY_USER_DETAILS, json);
        editor.commit();
    }

*/


/*


    public void setCurrentWeddingDetail(ModelWeddingList.DataBean modelWeddingList) {
        Gson gson = new Gson();
        String json = gson.toJson(modelWeddingList);
        editor.putString(KEY_CURRENT_WEDDING_DETAILS, json);
        editor.commit();
    }
    public ModelWeddingList.DataBean getCurrentWeddingDetail() {
        Gson gson = new Gson();
        String json = preferences.getString(KEY_CURRENT_WEDDING_DETAILS, "");
        return gson.fromJson(json, ModelWeddingList.DataBean.class);
    }
*/





    public void setUserLogin(boolean isSignedIn) {
        editor.putBoolean(KEY_IS_LOGGED_IN, isSignedIn);
        editor.commit();
    }


    public Boolean getBooleanValue(String key) {
        return this.preferences.getBoolean(key, false);
    }

    public void setBooleanValue(String key, boolean value) {
        this.editor.putBoolean(key, value);
        this.editor.commit();
    }

    public String getStringValue(String key) {
        return this.preferences.getString(key, "");
    }

    public void setStringValue(String key, String value) {
        this.editor.putString(key, value);
        this.editor.commit();
    }


    public void setLongitudeValue(String key, String value) {
        this.editor.putString(key, value);
        this.editor.commit();
    }

    public String getLongitudeValue(String key) {
        return this.preferences.getString(key, null);
    }






    public void clearPrefs() {
        this.editor.clear();
        this.editor.commit();
    }

    public void removeFromPreference(String key) {
        this.editor.remove(key);
        this.editor.commit();
    }

}