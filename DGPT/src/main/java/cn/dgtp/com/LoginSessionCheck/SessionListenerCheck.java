package cn.dgtp.com.LoginSessionCheck;

import java.util.Map;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListenerCheck
 *
 */
public class SessionListenerCheck implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListenerCheck() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  {
    	/*----*/
    	Map<String, String> map3 =
    			(Map<String, String>)se.getSession().getServletContext().getAttribute("LoginListenerMap");
    	System.out.println(map3);
    	for(Map.Entry<String, String> entry : map3.entrySet()) {
    		if (se.getSession().getId().equals(entry.getValue())) {
				map3.remove(entry.getKey());
			}
    	}
    	Map<String, String> map4 =
    			(Map<String, String>)se.getSession().getServletContext().getAttribute("session");
    	for(Map.Entry<String, String> entry : map4.entrySet()) {
    		if (se.getSession().equals(entry.getValue())) {
				map4.remove(entry.getKey());
			}
    	}
    }
	
}
