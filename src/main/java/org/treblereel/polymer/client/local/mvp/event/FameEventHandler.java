package org.treblereel.polymer.client.local.mvp.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created by treblereel on 6/16/16.
 */
public interface FameEventHandler extends EventHandler {
    void onFame(FameEvent event);
}