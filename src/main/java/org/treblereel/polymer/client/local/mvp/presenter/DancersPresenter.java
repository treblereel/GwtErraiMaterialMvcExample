package org.treblereel.polymer.client.local.mvp.presenter;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import org.slf4j.Logger;

import javax.inject.Inject;

/**
 * Created by treblereel on 6/14/16.
 */
public class DancersPresenter implements Presenter {


    public interface Display {
        Widget asWidget();
    }

    @Inject
    Logger logger;

    @Inject
    private Display display;

    @Override
    public void dispatch(HasWidgets container) {
        logger.info("dispatch");
        container.clear();
        container.add(display.asWidget());
    }
}
