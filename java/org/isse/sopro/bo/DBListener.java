package org.isse.sopro.bo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * At start of the Web app the DB Connection is launched so the first request is faster
 *
 */
public class DBListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SessionFactoryManager.instance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        SessionFactoryManager.instance().close();
    }
}
