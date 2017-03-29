package com.github.caffee.badge.launcher;

import android.content.Context;
import android.content.Intent;

public class LenovoLauncher extends AbstractLauncher implements Launcher.LENOVO {

    private final static LenovoLauncher instance = new LenovoLauncher();

    private LenovoLauncher() {}

    public final static LenovoLauncher getInstance() {
        return instance;
    }

    @Override
    public void notifyUpdate(final Context context, final int badgeCount) {
        Intent intent = new Intent(INTENT_ACTION);
        intent.putExtra(BADGE_COUNT, badgeCount);
        intent.putExtra(COMPONENT_NAME, getComponentName(context));
        context.sendBroadcast(intent);
    }

    @Override
    public void notifyRemove(final Context context) {
        notifyUpdate(context, 0);
    }
}
