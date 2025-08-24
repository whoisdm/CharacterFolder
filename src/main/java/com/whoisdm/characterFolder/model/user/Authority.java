package com.whoisdm.characterFolder.model.user;

import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {
    @EmbeddedId
    private AuthorityId id;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name = "username")
    private User user;

    public Authority() {
    }

    public Authority(User user, String authority) {
        this.user = user;
        this.id = new AuthorityId(user.getUsername(), authority);
    }

    public AuthorityId getId() {
        return id;
    }

    public void setId(AuthorityId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
