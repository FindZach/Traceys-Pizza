package com.findzach.restaurant.service.session;

import com.findzach.restaurant.model.session.SessionUser;
import com.findzach.restaurant.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Zach Smith
 * @date: 11/25/2023
 * @time: 12:04 PM
 */
@Service
public class SessionService implements CrudService<SessionUser, String> {

    private static final Map<String, SessionUser> sessionUserMap = new HashMap<>();

    public SessionUser getSessionUser(String sessionId) {
        return sessionUserMap.get(sessionId);
    }

    @Override
    public List<SessionUser> findAll() {
        return (List<SessionUser>) sessionUserMap.values();
    }

    @Override
    public SessionUser findById(String s) {
        return sessionUserMap.get(s);
    }

    @Override
    public SessionUser create(SessionUser object) {
        return sessionUserMap.put(object.getSession().getId(), object);
    }

    @Override
    public boolean delete(SessionUser object) {
        sessionUserMap.remove(object.getSession().getId());
        return true;
    }

    @Override
    public boolean deleteById(String s) {
        sessionUserMap.remove(s);
        return true;
    }
}
