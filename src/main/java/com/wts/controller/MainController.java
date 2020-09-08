package com.wts.controller;

import com.jfinal.core.Controller;

public class MainController extends Controller {

    public void index() {
        render("/ComplaintLetter.html");
    }
    public void SaveComplaintLetter() {
        System.out.println(get("ComplaintPersonName"));
        System.out.println(get("ComplaintPersonNumber"));
        render("/ComplaintLetter.html");
    }
}


