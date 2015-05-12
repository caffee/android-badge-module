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

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

public class SamsungLauncher extends AbstractLauncher implements Launcher.SAMSUNG {

    private static SamsungLauncher instance = new SamsungLauncher();

    private SamsungLauncher() {}

    public static SamsungLauncher getInstance() {
        return instance;
    }

    @Override
    public void notifyUpdate(final Context context, final int badgeCount) {
        ContentValues values = getContentValues(context, badgeCount);
        context.getContentResolver().insert(Uri.parse(CONTENT_URI), values);
    }

    @Override
    public void notifyRemove(final Context context) {
        String whereClause = COLUMN_CLASS + "=?";
        String[] arg = {getComponentName(context).getClassName()};
        context.getContentResolver().delete(Uri.parse(CONTENT_URI),whereClause, arg);
    }

    protected ContentValues getContentValues(final Context context, final int badgeCount) {
        ContentValues obj = new ContentValues();
        obj.put(COLUMN_PACKAGE, context.getPackageName());
        obj.put(COLUMN_CLASS, getComponentName(context).getClassName());
        obj.put(COLUMN_BADGE_COUNT, badgeCount);
        return  obj;
    }
}