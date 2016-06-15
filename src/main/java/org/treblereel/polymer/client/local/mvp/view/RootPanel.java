package org.treblereel.polymer.client.local.mvp.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialPanel;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class RootPanel extends Composite {

    @Inject
    Logger logger;


    @Inject
    Header header;

    @Inject
    @UiField
    MaterialPanel headerPanel;

    @Inject
    @UiField
    MaterialPanel container;

    @Inject
    @UiField
    MaterialPanel rootPanel;

    private static RootPanelClientUiBinder uiBinder = GWT.create(RootPanelClientUiBinder.class);

    interface RootPanelClientUiBinder extends UiBinder<Widget, RootPanel> {
    }

    @PostConstruct
    public void init(){
        logger.info("init");
        //headerPanel.add(header.asWidget());
        logger.info("init 2");

        initWidget(uiBinder.createAndBindUi(this));
        headerPanel.add(header.asWidget());
    }

    public Panel getContainer(){
        return container;
    }
}
