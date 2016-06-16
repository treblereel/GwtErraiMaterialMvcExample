package org.treblereel.polymer.client.local.mvp.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created by treblereel on 6/16/16.
 */
public interface ChampionshipsEventHandler extends EventHandler {
    void onChampionships(ChampionshipsEvent event);
}