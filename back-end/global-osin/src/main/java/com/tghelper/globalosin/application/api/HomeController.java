package com.tghelper.globalosin.application.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by infamouSs on 1/29/18.
 */
@Controller
public class HomeController {
    
    @RequestMapping(value = "/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }
}
