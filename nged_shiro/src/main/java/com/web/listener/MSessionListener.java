package com.web.listener;


import org.apache.logging.log4j.LogManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;

public class MSessionListener extends SessionListenerAdapter {
     private static final org.apache.logging.log4j.Logger LOG =  LogManager.getLogger();
    @Override
    public void onExpiration(Session session) {
        super.onExpiration(session);
        LOG.info("expiration "+session.getId());
    }

    @Override
    public void onStart(Session session) {
        super.onStart(session);
        LOG.info("Start "+session.getId());
    }

    @Override
    public void onStop(Session session) {
        super.onStop(session);
        LOG.info("Stop "+session.getId());
    }
}
