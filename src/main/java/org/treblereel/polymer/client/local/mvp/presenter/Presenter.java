package org.treblereel.polymer.client.local.mvp.presenter;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Created by treblereel on 6/14/16.
 */
public interface Presenter {
    void dispatch(final HasWidgets container);
}
