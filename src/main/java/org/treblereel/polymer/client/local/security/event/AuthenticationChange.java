package org.treblereel.polymer.client.local.security.event;

import org.jboss.errai.common.client.api.annotations.LocalEvent;

/**
 * Created by treblereel on 6/17/16.
 */
@LocalEvent
public class AuthenticationChange {
    private Authentication status;

    public Authentication getStatus() {
        return status;
    }

    public void setStatus(Authentication status) {
        this.status = status;
    }

    public static enum Authentication{
        LOGIN,LOGOUT;
    }



}
