/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.ds.notification.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author : Quang Tran Dang
 * Email: trandangquanghust@gmail.com
 * 10/08/2017
 */

@Controller
public class ViewController {

    @GetMapping(value = {"/"})
    public ModelAndView home(){
        return new ModelAndView("index");
    }
}
