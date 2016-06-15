package org.treblereel.polymer.client.local.mvp;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import org.slf4j.Logger;
import org.treblereel.polymer.client.local.mvp.event.DancersEvent;
import org.treblereel.polymer.client.local.mvp.event.DancersEventHandler;
import org.treblereel.polymer.client.local.mvp.event.MainEvent;
import org.treblereel.polymer.client.local.mvp.event.MainEventHandler;
import org.treblereel.polymer.client.local.mvp.presenter.DancersPresenter;
import org.treblereel.polymer.client.local.mvp.presenter.MainPresenter;
import org.treblereel.polymer.client.local.mvp.presenter.Presenter;

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

  private HasWidgets container;

  public void bind() {

    logger.info("bind");

    History.addValueChangeHandler(this);

    eventBus.addHandler(MainEvent.TYPE, event -> doMain());

    eventBus.addHandler(DancersEvent.TYPE, event -> doDancers());


  }

  private void doMain() {
      logger.info("doMain");
    History.newItem("main");
  }

  private void doDancers() {
      logger.info("doDancers");

      History.newItem("dancers");
  }

  public void dispatch(final HasWidgets container) {
      logger.info("dispatch");


      this.container = container;
    bind();

    if ("".equals(History.getToken())) {
      History.newItem("main");
    } else {
      History.fireCurrentHistoryState();
    }
  }

  public void onValueChange(ValueChangeEvent<String> event) {
    String token = event.getValue();

      logger.info("onValueChange "+token);


      if (token != null) {
      if (token.equals("main")) {
        mainPresenter.dispatch(container);
      } else if (token.equals("dancers")) {
        dancersPresenter.dispatch(container);
      }
    }
  }
}