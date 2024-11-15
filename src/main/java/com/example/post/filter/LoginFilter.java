//package com.example.post.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.weaver.tools.TypePatternMatcher;
//import org.springframework.util.PatternMatchUtils;
//
//import java.io.IOException;
//import java.rmi.RemoteException;
//
//@Slf4j
//public class LoginFilter implements Filter {
//
//    private static final String[] WHITE_LIST = {"/", "/members/signup"};
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest Request = (HttpServletRequest) servletRequest;
//        String requestURI = Request.getRequestURI();
//
//        HttpServletResponse Response = (HttpServletResponse) servletResponse;
//
//        log.info("로그인 필터 로직 실행");
//        if (!isWhiteList(requestURI)) {
//            HttpSession session = Request.getSession(false);
//
//            if(session==null || session.getAttribute("sessionKey")==null){
//                throw new RemoteException("로그인 해주세요.");
//            }
//
//            log.info("로그인에 성공했습니다");
//        }
//
//
//
//
//    }
//
//    private boolean isWhiteList(String requestURI) {
//        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
//    }
//}
