package org.treblereel.polymer.client.local.mvp;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import org.slf4j.Logger;
import org.treblereel.polymer.client.local.mvp.event.*;
import org.treblereel.polymer.client.local.mvp.presenter.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AppController implements Presenter, ValueChangeHandler<String> {

    @Inject
    Logger logger;

    @Inject
    private HandlerManager eventBus;

    @Inject
    private MainPresenter mainPresenter;

    @Inject
    private DancersPresenter dancersPresenter;

    @Inject
    private ChampionshipsPresenter championshipsPresenter;

    @Inject
    private SchoolsPresenter schoolsPresenter;

    @Inject
    private FamePresenter famePresenter;

    private HasWidgets container;

    @PostConstruct
    public void init(){
        bind();
    }

    public void bind() {
        History.addValueChangeHandler(this);
        eventBus.addHandler(MainEvent.TYPE, event -> doMain());
        eventBus.addHandler(DancersEvent.TYPE, event -> doDancers());
        eventBus.addHandler(ChampionshipsEvent.TYPE , event -> doChampionShips());
        eventBus.addHandler(SchoolsEvent.TYPE , event -> doSchools());
        eventBus.addHandler(FameEvent.TYPE , event -> doFame());



    }

    private void doFame() {
        History.newItem("fame");
    }

    private void doSchools() {
        History.newItem("schools");
    }

    private void doChampionShips() {
        History.newItem("championships");
    }

    private void doMain() {
        History.newItem("main");
    }

    private void doDancers() {
        History.newItem("dancers");
    }

    public void dispatch(final HasWidgets container) {
        this.container = container;
        if ("".equals(History.getToken())) {
            History.newItem("main");
        } else {
            History.fireCurrentHistoryState();
        }
    }

    public void onValueChange(ValueChangeEvent<String> event) {
        String token = event.getValue();
        if (token != null) {
            if (token.equals("main")) {
                mainPresenter.dispatch(container);
            } else if (token.equals("dancers")) {
                dancersPresenter.dispatch(container);
            }else if (token.equals("championships")) {
                championshipsPresenter.dispatch(container);
            }else if (token.equals("schools")) {
                schoolsPresenter.dispatch(container);
            }else if (token.equals("fame")) {
                famePresenter.dispatch(container);
            }
        }
    }
}