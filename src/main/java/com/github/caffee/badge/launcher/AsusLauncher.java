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

import android.content.Context;
import android.content.Intent;

public class AsusLauncher extends AbstractLauncher implements Launcher.ASUS {

    private final static AsusLauncher instance = new AsusLauncher();

    private AsusLauncher() {}

    public final static AsusLauncher getInstance() {
        return instance;
    }

    @Override
    public void notifyUpdate(final Context context, final int badgeCount) {
        Intent intent = new Intent(INTENT_ACTION);
        intent.putExtra(BADGE_COUNT, badgeCount);
        intent.putExtra(BADGE_COUNT_PACKAGE_NAME, context.getPackageName());
        intent.putExtra(BADGE_COUNT_CLASS_NAME,  getComponentName(context).getClassName());
        context.sendBroadcast(intent);
    }

    @Override
    public void notifyRemove(final Context context) {
        notifyUpdate (context, 0);
    }
}