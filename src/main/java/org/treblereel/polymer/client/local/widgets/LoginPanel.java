package org.treblereel.polymer.client.local.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.*;
import org.slf4j.Logger;
import org.treblereel.polymer.client.local.mvp.view.SchoolsView;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 * Created by treblereel on 6/16/16.
 */
@Dependent
public class LoginPanel extends Composite {


    @Inject
    Logger logger;

    @Inject
    MaterialWindow window;

/*
    private static LoginPanelUiBinder uiBinder = GWT.create(LoginPanelUiBinder.class);

    interface LoginPanelUiBinder extends UiBinder<Widget, LoginPanel> {
    }
*/


    @PostConstruct
    public void init(){
        //initWidget(uiBinder.createAndBindUi(this));

        window.setWidth("40%");
        MaterialLabel label = new MaterialLabel();
        label.setText("Login with credintals ...");
        window.add(label);

        MaterialTextBox login = new MaterialTextBox();
        login.setPlaceholder("Email");
        login.setType(InputType.EMAIL);
        window.add(login);


        MaterialTextBox password = new MaterialTextBox();
        password.setPlaceholder("Password");
        password.setType(InputType.PASSWORD);
        window.add(password);

        MaterialButton button = new MaterialButton();
        button.setText("Log In");
        button.setWaves(WavesType.GREEN);
        button.setBackgroundColor("blue");
        window.add(button);

        MaterialRow row = new MaterialRow();
        row.setMarginTop(30);
        MaterialColumn column = new MaterialColumn();

        MaterialCheckBox checkBox = new MaterialCheckBox();
        checkBox.setText("Keep me logged in");
        column.add(checkBox);

        MaterialColumn columnWithLabel = new MaterialColumn();
        columnWithLabel.add(new MaterialLabel("... or social networks"));

        row.add(column);
        row.add(columnWithLabel);

        MaterialRow social = new MaterialRow();

        MaterialColumn soColumn1 = new MaterialColumn();
        MaterialImage i1 = new MaterialImage();
        i1.setUrl("icons/social/svg/social-1_round-twitter.svg");
        i1.setType(ImageType.CIRCLE);
        i1.addClickHandler(c -> doTwitterLogin());
        soColumn1.add(i1);
        social.add(soColumn1);

        MaterialColumn soColumn2 = new MaterialColumn();
        MaterialImage i2 = new MaterialImage();
        i2.setUrl("icons/social/svg/social-1_round-facebook.svg");
        i2.setType(ImageType.CIRCLE);
        i2.addClickHandler(c -> doFacebookLogin());
        soColumn2.add(i2);
        social.add(soColumn2);

        MaterialColumn soColumn3 = new MaterialColumn();
        MaterialImage i3 = new MaterialImage();
        i3.setUrl("icons/social/svg/social-1_round-google-plus.svg");
        i3.setType(ImageType.CIRCLE);
        i3.addClickHandler(c -> doGoogleLogin());
        soColumn3.add(i3);
        social.add(soColumn3);


        window.add(row);
        window.add(social);

    }

    private void doTwitterLogin() {
        logger.info("let's do twitter login");

    }

    private void doGoogleLogin() {
        logger.info("let's do facebook login");
    }

    private void doFacebookLogin() {
        logger.info("let's do facebook login");
    }

    public MaterialWindow getWindow() {
        //window.add(this);
        return window;
    }
}
