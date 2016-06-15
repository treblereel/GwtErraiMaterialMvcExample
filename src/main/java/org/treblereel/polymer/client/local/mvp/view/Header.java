package org.treblereel.polymer.client.local.mvp.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.slf4j.Logger;

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

    private static HeaderUiBinder uiBinder = GWT.create(HeaderUiBinder.class);

    interface HeaderUiBinder extends UiBinder<Widget, Header> {
    }

    @PostConstruct
    public void init(){
        logger.info("init");
        initWidget(uiBinder.createAndBindUi(this));
    }
}
