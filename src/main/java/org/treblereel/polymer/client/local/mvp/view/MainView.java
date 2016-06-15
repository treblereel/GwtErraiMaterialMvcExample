package org.treblereel.polymer.client.local.mvp.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import org.slf4j.Logger;
import org.treblereel.polymer.client.local.mvp.presenter.MainPresenter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 * Created by treblereel on 6/14/16.
 */
@Dependent
public class MainView extends Composite implements MainPresenter.Display{

    @Inject
    Logger logger;

    private static MainViewUiBinder uiBinder = GWT.create(MainViewUiBinder.class);

    interface MainViewUiBinder extends UiBinder<Widget, MainView> {
    }


    @PostConstruct
    public void init(){
        logger.info("init");
        initWidget(uiBinder.createAndBindUi(this));
    }

    public Widget asWidget() {
        logger.info("asWidget");

        return this;
    }
}
