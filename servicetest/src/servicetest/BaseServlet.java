package servicetest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public abstract class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		String name=req.getParameter("method");
		if(name==null||name.trim().isEmpty()) {
			throw new RuntimeException("您没有传递method参数");
		}
		Class classname=this.getClass();
		Method method=null;
		try {
			method=classname.getMethod(name, HttpServletRequest.class,HttpServletResponse.class);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("还没有定义"+name+"这个方法！");
		} 
		String place=null;
		try {
			place=(String) method.invoke(this,req,res);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException("调用"+name+"这个方法失败");
		}
		
//		得到要处理的字符串过后开始处理
		if(place==null||place.trim().isEmpty()) {
			return;
		}
		else if(place.contains(":")) {
			String all[]=place.split(":", 3);
			String how=all[0];
			String where=all[1];
			if(how.equalsIgnoreCase("r")) {
				res.sendRedirect(req.getContextPath()+where);
			}
			else if(how.equalsIgnoreCase("f")) {
				req.getRequestDispatcher(where).forward(req, res);
			}
			else if(how.equalsIgnoreCase("d")) {
				
			}
			else {
				throw new RuntimeException(how+"你还没有定义这个方法");
			}
			
			
		}
		else {
			req.getRequestDispatcher(place).forward(req, res);
		}
		
	}
	
}
