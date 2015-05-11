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

import com.github.caffee.badge.launcher.AbstractLauncher;
import com.github.caffee.badge.launcher.Launcher;

import android.content.Context;

public class BadgeBroadcastManager extends BaseManager implements Launcher {
    private Context context;
    private AbstractLauncher launcher;

    public BadgeBroadcastManager(final Context context) {
        super(context);
        this.context = context;
        this.launcher = getLauncherInstance();
    }

    public void notifyUpdate(final int badgeCount) {
        if(launcher != null) {
            int count = getSharedPreferencesBadgeCount() + badgeCount;
            setSharedPreferencesBadgeCount(count);
            launcher.notifyUpdate(context, count);
            hWNotification(context);
        }
    }

    public void notifyRemove() {
        if(launcher != null) {
            if (getSharedPreferencesBadgeCount() > 0) {
                setSharedPreferencesBadgeCount(0);
                launcher.notifyRemove(context);
            }
        }
    }
}