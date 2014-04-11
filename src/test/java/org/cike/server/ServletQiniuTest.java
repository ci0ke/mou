package org.cike.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class ServletQiniuTest extends ServletTest {

	
	
	@Test
	public void testupdate() throws IOException, ServletException {
		final String name=System.nanoTime()+"";
		Map map=new HashMap(){
			{
			 put("name",name);
			 put("file","D:/remark/eclipse.txt");
			}
		};
		setAttribute(map);
		
		ServletQiniu sampleServlet = new ServletQiniu();

		sampleServlet
				.doAction(stubHttpServletRequest, stubHttpServletResponse);
		
		
		
		
		String result = sw.getBuffer().toString().trim();

		
		System.out.println(result);

		TestCase.assertEquals(result, name);

	}
	
	

}