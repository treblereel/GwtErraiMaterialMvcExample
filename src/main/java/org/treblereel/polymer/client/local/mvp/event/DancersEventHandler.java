package org.treblereel.polymer.client.local.mvp.event;

import com.google.gwt.event.shared.EventHandler;

public interface DancersEventHandler extends EventHandler {
    void onDancers(DancersEvent event);
}