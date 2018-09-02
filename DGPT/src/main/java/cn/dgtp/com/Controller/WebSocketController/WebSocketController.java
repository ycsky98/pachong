package cn.dgtp.com.Controller.WebSocketController;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import cn.dgtp.com.WebSocket.GetHttpSession;

/**
 * configurator该注解用于引用获取httpSession类,该类需要是Configurator类及其子类
 * */
@ServerEndpoint(value="/speakLogins",configurator=GetHttpSession.class)
public class WebSocketController {
	
	/**
	 * 打开链接时的操作
	 * */
	@OnOpen
	public void open(Session session,EndpointConfig config){
		//获取Httpsession
		HttpSession session2 = (HttpSession)config.getUserProperties().get(HttpSession.class.getName());
		
		/*--获取全局socket容器--*/
		Map<String, Session> map = (Map<String, Session>)session2.getServletContext().getAttribute("websocketSession");
		/*--每链接一个用户,将套接字存入容器--*/
		map.put(session2.getId(), session);
		session2.getServletContext().setAttribute("websocketSession", map);
	}
	
	/**
	 * 关闭websocket时操作
	 * */
	@OnClose
	public void close(CloseReason c){
	}
}