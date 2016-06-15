package org.treblereel.polymer.client.local.mvp.presenter;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class MainPresenter implements Presenter{

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
