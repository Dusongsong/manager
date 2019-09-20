package cn.huateng.server;

import cn.huateng.server.core.Request;
import cn.huateng.server.core.Response;
import cn.huateng.server.core.Servlet;

public class RegisterServlet implements Servlet {

	@Override
	public void service(Request request, Response response) {
		response.print("注册成功"); 
	}

}
