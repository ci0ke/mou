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

public class ServletTest extends Mockito {

	HttpServletRequest stubHttpServletRequest;
	HttpServletResponse stubHttpServletResponse;
	StringWriter sw = new StringWriter();

	@Before
	public void initing() throws IOException {
		stubHttpServletRequest = mock(HttpServletRequest.class);
		stubHttpServletResponse = mock(HttpServletResponse.class);
		HttpSession stubHttpSession = mock(HttpSession.class);
		when(stubHttpServletRequest.getSession()).thenReturn(stubHttpSession);
		PrintWriter pw = new PrintWriter(sw);
		when(stubHttpServletResponse.getWriter()).thenReturn(pw);
	}

	protected void setAttribute(Map map) {
		Set<Entry> set = map.entrySet();
		for (Entry<String, Object> entry : set) {
			when(stubHttpServletRequest.getParameter(entry.getKey()))
					.thenReturn(entry.getValue().toString());
		}
	}

}