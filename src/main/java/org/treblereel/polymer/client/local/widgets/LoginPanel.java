package org.treblereel.polymer.client.local.widgets;

import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.user.client.ui.Composite;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.*;
import org.slf4j.Logger;
import org.treblereel.polymer.client.local.security.event.AuthenticationChange;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
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

    @Inject
    private Event<AuthenticationChange> authentication;

    @PostConstruct
    public void init(){
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
        button.setBackgroundColor(Color.BLUE);
        button.addClickHandler(c->doLogin());
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
        i1.addMouseOverHandler( event -> onSocialButtonMouseOverHandler(event));
        i1.addMouseOutHandler( event -> onSocialButtonMouseOutHandler(event));
        soColumn1.add(i1);
        social.add(soColumn1);

        MaterialColumn soColumn2 = new MaterialColumn();
        MaterialImage i2 = new MaterialImage();
        i2.setUrl("icons/social/svg/social-1_round-facebook.svg");
        i2.setType(ImageType.CIRCLE);
        i2.addClickHandler(c -> doFacebookLogin());
        i2.addMouseOverHandler( event -> onSocialButtonMouseOverHandler(event));
        i2.addMouseOutHandler( event -> onSocialButtonMouseOutHandler(event));
        soColumn2.add(i2);
        social.add(soColumn2);

        MaterialColumn soColumn3 = new MaterialColumn();
        MaterialImage i3 = new MaterialImage();
        i3.setUrl("icons/social/svg/social-1_round-google-plus.svg");
        i3.setType(ImageType.CIRCLE);
        i3.addClickHandler(c -> doGoogleLogin());
        i3.addMouseOverHandler( event -> onSocialButtonMouseOverHandler(event));
        i3.addMouseOutHandler( event -> onSocialButtonMouseOutHandler(event));
        soColumn3.add(i3);
        social.add(soColumn3);

        window.add(row);
        window.add(social);

    }

    private void onSocialButtonMouseOverHandler(MouseOverEvent event ) {
        MaterialImage source = (MaterialImage)event.getSource();
        source.setBackgroundColor(Color.ORANGE);
    }

    private void onSocialButtonMouseOutHandler(MouseOutEvent event) {
        MaterialImage source = (MaterialImage)event.getSource();
        source.setBackgroundColor(Color.AMBER);
    }

    private void doLogin() {
        AuthenticationChange event = new AuthenticationChange();
        event.setStatus(AuthenticationChange.Authentication.LOGIN);
        authentication.fire(event);
        window.close();
    }

    private void doTwitterLogin() {
        logger.debug("let's do twitter login");

    }

    private void doGoogleLogin() {
        logger.debug("let's do facebook login");
    }

    private void doFacebookLogin() {
        logger.debug("let's do facebook login");
    }

    public MaterialWindow getWindow() {
        return window;
    }
}
