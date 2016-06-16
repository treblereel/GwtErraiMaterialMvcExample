package org.treblereel.polymer.client.local.mvp.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by treblereel on 6/16/16.
 */
public class FameEvent extends GwtEvent<FameEventHandler> {
    public static Type<FameEventHandler> TYPE = new Type<>();

    @Override
    public Type<FameEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(FameEventHandler handler) {
        handler.onFame(this);
    }
}
