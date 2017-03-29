/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Lee <lee.github@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.caffee.badge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;

import com.github.caffee.badge.launcher.AbstractLauncher;
import com.github.caffee.badge.launcher.AsusLauncher;
import com.github.caffee.badge.launcher.HtcLauncher;
import com.github.caffee.badge.launcher.Launcher;
import com.github.caffee.badge.launcher.LenovoLauncher;
import com.github.caffee.badge.launcher.SamsungLauncher;
import com.github.caffee.badge.launcher.SonyEricssonLauncher;

import java.util.Arrays;

public class BaseManager {

    final static String BADGE_COUNT = "badge_count";

    private Context context;
    private SharedPreferences preferences;

    public BaseManager(final Context context) {
        this.context = context;
        this.preferences = this.context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    final void setSharedPreferencesBadgeCount(final int badgeCount) {
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(BADGE_COUNT, badgeCount);
        editor.commit();
    }

    final int getSharedPreferencesBadgeCount() {
        return preferences.getInt(BADGE_COUNT, 0);
    }

    final String getLauncherName() {
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        final ResolveInfo resolveInfo = context.getPackageManager().resolveActivity(intent, 0);

        return resolveInfo.activityInfo.packageName;
    }

    final AbstractLauncher getLauncherInstance() {
        // asus
        if (Arrays.asList(Launcher.ASUS.LAUNCHER_NAME).contains(getLauncherName())) {
            return AsusLauncher.getInstance();
        }
        // sonyericsson
        if (Arrays.asList(Launcher.SONYERICSSON.LAUNCHER_NAME).contains(getLauncherName())) {
            return SonyEricssonLauncher.getInstance();
        }
        // htc
        if (Arrays.asList(Launcher.HTC.LAUNCHER_NAME).contains(getLauncherName())) {
            return HtcLauncher.getInstance();
        }
        // samsung
        if (Arrays.asList(Launcher.SAMSUNG.LAUNCHER_NAME).contains(getLauncherName())) {
            return SamsungLauncher.getInstance();
        }
        // lenovo
        if (Arrays.asList(Launcher.LENOVO.LAUNCHER_NAME).contains(getLauncherName())) {
            return LenovoLauncher.getInstance();
        }
        return null;
    }

    final void hWNotification(final Context context) {
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone ringtone = RingtoneManager.getRingtone(context, notification);
        ringtone.play();

        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator.hasVibrator()) {
            long[] pattern = {0, 200, 100, 100};
            vibrator.vibrate(pattern, -1);
        }
    }
}