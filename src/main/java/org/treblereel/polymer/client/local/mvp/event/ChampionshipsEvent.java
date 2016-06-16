package org.treblereel.polymer.client.local.mvp.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by treblereel on 6/16/16.
 */
public class ChampionshipsEvent extends GwtEvent<ChampionshipsEventHandler> {
    public static Type<ChampionshipsEventHandler> TYPE = new Type<>();

    @Override
    public Type<ChampionshipsEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ChampionshipsEventHandler handler) {
        handler.onChampionships(this);
    }
}
