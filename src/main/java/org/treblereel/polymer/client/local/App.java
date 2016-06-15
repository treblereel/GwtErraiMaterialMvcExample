package org.treblereel.polymer.client.local;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialPanel;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.slf4j.Logger;
import org.treblereel.polymer.client.local.mvp.AppController;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@EntryPoint
public class App extends Composite {

    private HandlerManager eventBus = new HandlerManager(null);


    @Inject
    Logger logger;

    @Inject
    org.treblereel.polymer.client.local.mvp.view.RootPanel rootPanel;

    @Inject
    private AppController appController;

    @PostConstruct
    public void init() {
        RootPanel.get().add(rootPanel);
        appController.dispatch(rootPanel.getContainer());
    }

    @Produces
    private HandlerManager produceEventBus() {
        return eventBus;
    }

}