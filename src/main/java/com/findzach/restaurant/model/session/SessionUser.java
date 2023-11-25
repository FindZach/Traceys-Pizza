package com.findzach.restaurant.model.session;

import javax.servlet.http.HttpSession;

/**
 * @author: Zach Smith
 * @date: 11/25/2023
 * @time: 12:01 PM
 */
public class SessionUser {
    private final HttpSession session;

    private Long userId;

    public SessionUser(HttpSession session) {
        this.session = session;
    }

    public HttpSession getSession() {
        return session;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}