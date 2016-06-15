package org.treblereel.polymer.client.local.mvp.event;

import com.google.gwt.event.shared.GwtEvent;

public class DancersEvent extends GwtEvent<DancersEventHandler> {
    public static Type<DancersEventHandler> TYPE = new Type<>();

    @Override
    public Type<DancersEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DancersEventHandler handler) {
        handler.onDancers(this);
    }
}
