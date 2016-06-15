package org.treblereel.polymer.client.local.mvp.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created by treblereel on 6/14/16.
 */
public interface MainEventHandler extends EventHandler {
    void onMain(MainEvent event);
}
