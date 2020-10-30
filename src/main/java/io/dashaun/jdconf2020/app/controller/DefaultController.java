package io.dashaun.jdconf2020.app.controller;

import io.dashaun.jdconf2020.app.domain.PageView;
import io.dashaun.jdconf2020.app.filter.RequestFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class DefaultController {

    private CrudRepository<PageView, String> repository;

    @Value("${application.defaultMessage}")
    private String message;

    @Value("${application.dumpMessage}")
    private String dumpMessage;

    public DefaultController(CrudRepository<PageView, String> repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String main(Model model) {
        Model hitCount = model.addAttribute("hitCount", repository.count());
        model.addAttribute("message", message);
        return "index";
    }

    @GetMapping("/dump")
    public String dump(Model model) {
        model.addAttribute("hitCount", repository.count());
        model.addAttribute("message", dumpMessage);
        for (PageView h : repository.findAll()) {
            log.error(String.valueOf(h));
        }
        return "index";
    }

    @Bean
    public FilterRegistrationBean<RequestFilter> requestFilter() {
        FilterRegistrationBean<RequestFilter> registrationBean
                = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestFilter(repository));
        registrationBean.addUrlPatterns("/");
        return registrationBean;
    }

}