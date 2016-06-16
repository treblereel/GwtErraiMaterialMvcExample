package org.treblereel.polymer.client.local.mvp.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.slf4j.Logger;
import org.treblereel.polymer.client.local.mvp.presenter.ChampionshipsPresenter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 * Created by treblereel on 6/16/16.
 */
@Dependent
public class ChampionshipsView extends Composite implements ChampionshipsPresenter.Display {

    @Inject
    Logger logger;

    private static ChampionshipsViewUiBinder uiBinder = GWT.create(ChampionshipsViewUiBinder.class);

    interface ChampionshipsViewUiBinder extends UiBinder<Widget, ChampionshipsView> {
    }

    @PostConstruct
    public void init(){
        initWidget(uiBinder.createAndBindUi(this));
    }

    public Widget asWidget() {
        return this;
    }
}
