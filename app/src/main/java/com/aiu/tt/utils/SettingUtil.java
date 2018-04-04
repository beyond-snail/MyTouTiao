package com.aiu.tt.utils;

////////////////////////////////////////////////////////////////////
//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//              佛祖保佑       永无BUG     永不修改                  //
//                                                                //
//          佛曰:                                                  //
//                  写字楼里写字间，写字间里程序员；                   //
//                  程序人员写程序，又拿程序换酒钱。                   //
//                  酒醒只在网上坐，酒醉还来网下眠；                   //
//                  酒醉酒醒日复日，网上网下年复年。                   //
//                  但愿老死电脑间，不愿鞠躬老板前；                   //
//                  奔驰宝马贵者趣，公交自行程序员。                   //
//                  别人笑我忒疯癫，我笑自己命太贱；                   //
//                  不见满街漂亮妹，哪个归得程序员？                   //
////////////////////////////////////////////////////////////////////

import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;

import com.aiu.tt.InitApp;
import com.aiu.tt.R;

/**********************************************************
 *                                                        *
 *                  Created by wucongpeng on 2018/4/3.        *
 **********************************************************/


public class SettingUtil {
    private SharedPreferences setting = PreferenceManager.getDefaultSharedPreferences(InitApp.AppContext);

    private final static class SettingsUtilInstance{
        private static final SettingUtil instance = new SettingUtil();
    }

    public static SettingUtil getInstance(){
        return SettingsUtilInstance.instance;
    }


    /**
     * 获取是否开启无图模式
     * @return
     */
    public boolean getIsNoPhotoMode(){
        return setting.getBoolean("switch_noPhotoMode", false) && NetWorkUtil.isMobileConnected(InitApp.AppContext);
    }

    /**
     * 获取主题颜色
     */
    public int getColor() {
        int defaultColor = InitApp.AppContext.getResources().getColor(R.color.colorPrimary);
        int color = setting.getInt("color", defaultColor);
        if ((color != 0) && Color.alpha(color) != 255) {
            return defaultColor;
        }
        return color;
    }

    /**
     * 设置主题颜色
     */
    public void setColor(int color) {
        setting.edit().putInt("color", color).apply();
    }

    /**
     * 获取是否开启夜间模式
     */
    public boolean getIsNightMode() {
        return setting.getBoolean("switch_nightMode", false);
    }

    /**
     * 设置夜间模式
     */
    public void setIsNightMode(boolean flag) {
        setting.edit().putBoolean("switch_nightMode", flag).apply();
    }

    /**
     * 获取是否开启自动切换夜间模式
     */
    public boolean getIsAutoNightMode() {
        return setting.getBoolean("auto_nightMode", false);
    }


    /**
     * 获取是否开启自动切换夜间模式
     */
    public void setIsAutoNightMode(boolean flag) {
        setting.edit().putBoolean("auto_nightMode", flag).apply();
    }

    public String getNightStartHour() {
        return setting.getString("night_startHour", "22");
    }

    public void setNightStartHour(String nightStartHour) {
        setting.edit().putString("night_startHour", nightStartHour).apply();
    }

    public String getNightStartMinute() {
        return setting.getString("night_startMinute", "00");
    }

    public void setNightStartMinute(String nightStartMinute) {
        setting.edit().putString("night_startMinute", nightStartMinute).apply();
    }

    public String getDayStartHour() {
        return setting.getString("day_startHour", "06");
    }

    public void setDayStartHour(String dayStartHour) {
        setting.edit().putString("day_startHour", dayStartHour).apply();
    }

    public String getDayStartMinute() {
        return setting.getString("day_startMinute", "00");
    }

    public void setDayStartMinute(String dayStartMinute) {
        setting.edit().putString("day_startMinute", dayStartMinute).apply();
    }

    /**
     * 获取是否开启导航栏上色
     */
    public boolean getNavBar() {
        return setting.getBoolean("nav_bar", false);
    }

    /**
     * 获取是否开启视频强制横屏
     */
    public boolean getIsVideoForceLandscape() {
        return setting.getBoolean("video_force_landscape", false);
    }

    /**
     * 获取图标值
     */
    public int getCustomIconValue() {
        String s = setting.getString("custom_icon", "0");
        return Integer.parseInt(s);
    }

    /**
     * 获取滑动返回值
     */
    public int getSlidable() {
        String s = setting.getString("slidable", "1");
        return Integer.parseInt(s);
    }

    /**
     * 获取是否开启视频自动播放
     */
    public boolean getIsVideoAutoPlay() {
        return setting.getBoolean("video_auto_play", false) && NetWorkUtil.isWifiConnected(InitApp.AppContext);
    }

    /**
     * 获取字体大小
     */
    public int getTextSize() {
        return setting.getInt("textsize", 16);
    }

    /**
     * 设置字体大小
     */
    public void setTextSize(int textSize) {
        setting.edit().putInt("textsize", textSize).apply();
    }

    public boolean getIsFirstTime() {
        return setting.getBoolean("first_time", true);
    }

    public void setIsFirstTime(boolean flag) {
        setting.edit().putBoolean("first_time", flag).apply();
    }

}
