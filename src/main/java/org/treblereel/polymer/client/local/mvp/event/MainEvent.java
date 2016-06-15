package org.treblereel.polymer.client.local.mvp.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by treblereel on 6/14/16.
 */
public class MainEvent extends GwtEvent<MainEventHandler> {
    public static Type<MainEventHandler> TYPE = new Type<>();

    @Override
    public Type<MainEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(MainEventHandler handler) {
        handler.onMain(this);
    }
}
