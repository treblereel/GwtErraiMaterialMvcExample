package org.treblereel.polymer.client.local.mvp.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.slf4j.Logger;
import org.treblereel.polymer.client.local.mvp.presenter.SchoolsPresenter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 * Created by treblereel on 6/16/16.
 */
@Dependent
public class SchoolsView extends Composite implements SchoolsPresenter.Display {

    @Inject
    Logger logger;

    private static SchoolsViewUiBinder uiBinder = GWT.create(SchoolsViewUiBinder.class);

    interface SchoolsViewUiBinder extends UiBinder<Widget, SchoolsView> {
    }


    @PostConstruct
    public void init(){
        initWidget(uiBinder.createAndBindUi(this));
    }

    public Widget asWidget() {
        return this;
    }
}
