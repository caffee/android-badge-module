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

package com.github.caffee.badge.launcher;

public interface Launcher {

    public interface ASUS {
        String[] LAUNCHER_NAME = {"com.asus.launcher"};

        String INTENT_ACTION = "android.intent.action.BADGE_COUNT_UPDATE";
        String BADGE_COUNT = "badge_count";
        String BADGE_COUNT_PACKAGE_NAME = "badge_count_package_name";
        String BADGE_COUNT_CLASS_NAME = "badge_count_class_name";
        String BADGE_VIP_COUNT = "badge_vip_count"; // extra feature
    }

    public interface SONYERICSSON {
        String [] LAUNCHER_NAME = {"com.sonyericsson.home"};

        String INTENT_ACTION = "com.sonyericsson.home.action.UPDATE_BADGE";
        String BADGE_COUNT = "com.sonyericsson.home.intent.extra.badge.MESSAGE";
        String BADGE_COUNT_PACKAGE_NAME = "com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME";
        String BADGE_COUNT_CLASS_NAME = "com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME";
        String BADGE_SHOW_MESSAGE = "com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE";
    }

    public interface HTC {
        String[] LAUNCHER_NAME = {"com.htc.launcher"};

        String INTENT_ACTION = "com.htc.launcher.action.SET_NOTIFICATION";
        String BADGE_COUNT = "com.htc.launcher.extra.COUNT";
        String BADGE_COUNT_COMPONENT = "com.htc.launcher.extra.COMPONENT";
        String BADGE_COUNT_DATA = "com.htc.launcher.extra.DATA";
    }

    public interface SAMSUNG {
        String[] LAUNCHER_NAME = {"com.sec.android.app.launcher"};

        String CONTENT_URI = "content://com.sec.badge/apps";
        String COLUMN_PACKAGE = "package";
        String COLUMN_CLASS = "class";
        String COLUMN_BADGE_COUNT = "badgecount";
        String COLUMN_ICON = "icon";             // extra feature
        String COLUMN_EXTRA_DATA = "extraData";  // extra feature
    }
}