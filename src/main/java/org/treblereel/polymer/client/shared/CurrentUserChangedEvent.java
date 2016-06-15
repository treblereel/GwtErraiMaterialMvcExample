package org.treblereel.polymer.client.shared;

import org.jboss.errai.common.client.api.annotations.LocalEvent;

@LocalEvent
public class CurrentUserChangedEvent {

    private UserDTO user;


    public CurrentUserChangedEvent(UserDTO user) {

        setUser(user);

    }


    public void setUser(UserDTO user) {

        this.user = user;

    }


    public UserDTO getUser() {

        return user;

    }

}
