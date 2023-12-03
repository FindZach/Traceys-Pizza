package com.findzach.restaurant.model.session;

import com.findzach.restaurant.model.entities.user.Role;

import javax.servlet.http.HttpSession;

/**
 * @author: Zach Smith
 * @date: 11/25/2023
 * @time: 12:01 PM
 */
public class SessionUser {
    private final HttpSession session;

    private boolean requestedLogout = false;
    private Role sessionUserRole = Role.GUEST;
    private Long userId;

    public SessionUser(HttpSession session) {
        userId = session.getLastAccessedTime();
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

    public void setRole(Role role) {
        this.sessionUserRole = role;
    }
    public Role getSessionUserRole() {
        return sessionUserRole;
    }

    public boolean isRequestedLogout() {
        return requestedLogout;
    }

    public void setRequestedLogout(boolean requestedLogout) {
        this.requestedLogout = requestedLogout;
    }

    public void setSessionUserRole(Role sessionUserRole) {
        this.sessionUserRole = sessionUserRole;
    }
}
