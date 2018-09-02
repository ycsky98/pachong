package cn.dgtp.com.ContextListenerCheck;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Application Lifecycle Listener implementation class ContextListenerCheck
 */
public class ContextListenerCheck implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListenerCheck() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     * 容器一加载做的事情
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	ServletContext sc = sce.getServletContext();
    	//存储登陆用户的sessionID和用户名
    	sc.setAttribute("LoginListenerMap", new ConcurrentHashMap<String, String>());
    	//存储登陆用户的session//key为sessionID
    	sc.setAttribute("session", new ConcurrentHashMap<String, HttpSession>());
    	//存储对应session的websocket
    	sc.setAttribute("websocketSession", new ConcurrentHashMap<String,Session>());
    }
}
