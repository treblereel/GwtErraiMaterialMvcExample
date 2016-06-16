package org.treblereel.polymer.client.local.mvp.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.FlexAlignContent;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialPanel;
import org.slf4j.Logger;
import org.treblereel.polymer.client.local.widgets.LoginPanel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 * Created by treblereel on 6/14/16.
 */
@Dependent
public class Header extends Composite {

    @Inject
    Logger logger;

    @Inject
    @UiField
    MaterialLink loginButton;

    @Inject
    LoginPanel loginPanel;

    private static HeaderUiBinder uiBinder = GWT.create(HeaderUiBinder.class);

    interface HeaderUiBinder extends UiBinder<Widget, Header> {
    }

    @PostConstruct
    public void init(){
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("loginButton")
    void showLoginWindow(ClickEvent e){
        loginPanel.getWindow().openWindow();
        logger.info("loginButton");

    }

}