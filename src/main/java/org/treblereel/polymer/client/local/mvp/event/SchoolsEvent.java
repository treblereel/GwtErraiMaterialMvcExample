package org.treblereel.polymer.client.local.mvp.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by treblereel on 6/16/16.
 */
public class SchoolsEvent extends GwtEvent<SchoolsEventHandler> {
    public static Type<SchoolsEventHandler> TYPE = new Type<>();

    @Override
    public Type<SchoolsEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(SchoolsEventHandler handler) {
        handler.onSchools(this);
    }
}