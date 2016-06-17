package org.treblereel.polymer.client.local.mvp.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.FlexAlignContent;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialTooltip;
import org.slf4j.Logger;
import org.treblereel.polymer.client.local.security.event.AuthenticationChange;
import org.treblereel.polymer.client.local.widgets.LoginPanel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by treblereel on 6/14/16.
 */
@Dependent
public class Header extends Composite {

    private List<MaterialLink> links = new ArrayList<>();

    @Inject
    Logger logger;

    @Inject
    @UiField
    MaterialLink loginButton;

    @Inject
    LoginPanel loginPanel;

    @Inject
    private Event<AuthenticationChange> authentication;

    @Inject
    @UiField
    MaterialTooltip loginToolTip;

    @Inject
    @UiField
    MaterialLink main;

    @Inject
    @UiField
    MaterialLink dancers;

    @Inject
    @UiField
    MaterialLink schools;

    @Inject
    @UiField
    MaterialLink championships;

    @Inject
    @UiField
    MaterialLink fame;


    private static HeaderUiBinder uiBinder = GWT.create(HeaderUiBinder.class);

    interface HeaderUiBinder extends UiBinder<Widget, Header> {
    }

    @PostConstruct
    public void init() {
        initWidget(uiBinder.createAndBindUi(this));
        links.add(dancers);
        links.add(schools);
        links.add(championships);
        links.add(fame);
        changeLinksVisibility(false);
    }

    @UiHandler("loginButton")
    void showLoginWindowOrLogout(ClickEvent e) {
        if (loginToolTip.getText().equals("Logout")) {
            AuthenticationChange event = new AuthenticationChange();
            event.setStatus(AuthenticationChange.Authentication.LOGOUT);
            authentication.fire(event);
        } else {
            loginPanel.getWindow().openWindow();
            logger.info("loginButton");
        }
    }

    public void onAuthenticationChange(@Observes AuthenticationChange authenticationChange) {
        logger.info("onAuthenticationChange " + authenticationChange.getStatus());
        if (authenticationChange.getStatus().equals(AuthenticationChange.Authentication.LOGIN)) {
            onLogin();
        } else if (authenticationChange.getStatus().equals(AuthenticationChange.Authentication.LOGOUT)) {
            onLogout();
        }
    }


    private void onLogin(){
        loginToolTip.setText("Logout");
        loginButton.setIconType(IconType.INSERT_EMOTICON);
        changeLinksVisibility(true);
    }

    private void onLogout(){
        loginToolTip.setText("Login");
        loginButton.setIconType(IconType.ACCOUNT_CIRCLE);
        changeLinksVisibility(false);
    }

    private void changeLinksVisibility(Boolean state){
        for(MaterialLink l: links){
            l.setEnabled(state);
            l.setVisible(state);
        }
    }

}