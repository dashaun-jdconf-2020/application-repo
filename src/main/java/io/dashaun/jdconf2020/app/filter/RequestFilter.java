package io.dashaun.jdconf2020.app.filter;

import io.dashaun.jdconf2020.app.domain.PageView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class RequestFilter implements Filter {

    private final CrudRepository<PageView,String> repository;

    public RequestFilter(CrudRepository<PageView,String> repository){
        this.repository = repository;
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        log.error("remote host:" + servletRequest.getRemoteHost());
        log.error("local address:" + servletRequest.getLocalAddr());
        servletRequest.getRemoteHost();
        PageView pageView = new PageView();
        pageView.setLocalAddr(servletRequest.getLocalAddr());
        pageView.setRemoteAddr(servletRequest.getRemoteAddr());
        repository.save(pageView);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
