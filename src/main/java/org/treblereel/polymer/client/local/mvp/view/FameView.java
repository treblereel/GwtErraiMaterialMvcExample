package org.treblereel.polymer.client.local.mvp.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.slf4j.Logger;
import org.treblereel.polymer.client.local.mvp.presenter.FamePresenter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 * Created by treblereel on 6/16/16.
 */
@Dependent
public class FameView extends Composite implements FamePresenter.Display {

    @Inject
    Logger logger;

    private static FameViewUiBinder uiBinder = GWT.create(FameViewUiBinder.class);

    interface FameViewUiBinder extends UiBinder<Widget, FameView> {
    }

    @PostConstruct
    public void init(){
        initWidget(uiBinder.createAndBindUi(this));
    }

    public Widget asWidget() {
        return this;
    }
}
