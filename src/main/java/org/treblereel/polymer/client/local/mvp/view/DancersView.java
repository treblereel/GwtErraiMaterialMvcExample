package org.treblereel.polymer.client.local.mvp.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.slf4j.Logger;
import org.treblereel.polymer.client.local.mvp.presenter.DancersPresenter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class DancersView extends Composite implements DancersPresenter.Display{

    @Inject
    Logger logger;

    private static DancersViewUiBinder uiBinder = GWT.create(DancersViewUiBinder.class);

    interface DancersViewUiBinder extends UiBinder<Widget, DancersView> {
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
