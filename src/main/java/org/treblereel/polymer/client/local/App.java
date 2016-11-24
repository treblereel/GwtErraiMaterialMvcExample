package org.treblereel.polymer.client.local;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import org.jboss.errai.ioc.client.api.AfterInitialization;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.treblereel.polymer.client.local.mvp.AppController;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@EntryPoint
public class App extends Composite {

    private HandlerManager eventBus = new HandlerManager(null);

    @Inject
    org.treblereel.polymer.client.local.mvp.view.RootPanel rootPanel;

    @Inject
    private AppController appController;

    @PostConstruct
    public void init() {
        RootPanel.get().add(rootPanel);
    }

    @AfterInitialization
    public void onReady(){
        appController.dispatch(rootPanel.getContainer());
    }

    @Produces
    private HandlerManager produceEventBus() {
        return eventBus;
    }

}