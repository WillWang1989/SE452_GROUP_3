package edu.depaul.se452.windycityflyers.filter;

import edu.depaul.se452.windycityflyers.model.Logs;
import edu.depaul.se452.windycityflyers.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.HashMap;

@Component
public class LoggingFilter implements Filter {

    @Autowired
    private LogsService logsService;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Remote Host:"+request.getRemoteHost());
        System.out.println("Remote Address:"+request.getRemoteAddr());
        chain.doFilter(request, response);
        HttpServletRequest req =(HttpServletRequest) request;
        HttpServletResponse res =(HttpServletResponse) response;
        Logs log1 = new Logs();
        log1.setUrl(req.getRequestURI());
        log1.setProtocol(req.getProtocol());
        log1.setUserAgent(req.getHeader("user-agent"));
        log1.setHttpMethod(req.getMethod());
        log1.setContentType(res.getContentType());
        HashMap<String,String> cookies = new HashMap();
        Cookie [] list = req.getCookies();
        if(list!=null){

            for (Cookie cookie : list) {
                cookies.put(cookie.getName(),cookie.getValue());
            }
        }
        log1.setCookies(cookies);
        HashMap<String,String> headers = new HashMap<>();
        Enumeration<String> headerNames = req.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String key =headerNames.nextElement();
                headers.put(key,req.getHeader(key));
            }
        }
        log1.setHeaders(headers);
        log1.setStatusCode(res.getStatus()+"");
        log1.setRequestDate(LocalDateTime.now());
        // skip css and js request
        if(log1.getUrl().endsWith(".css")||log1.getUrl().endsWith(".js"))
            return;

        logsService.update(log1);

    }
}
