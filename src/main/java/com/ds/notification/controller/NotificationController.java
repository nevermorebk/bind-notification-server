/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.ds.notification.controller;

import com.ds.notification.model.request.BindVersionRequest;
import com.ds.notification.model.request.NotificationRequest;
import com.ds.notification.service.NotificationService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Author : Quang Tran Dang
 * Email: trandangquanghust@gmail.com
 * 09/08/2017
 */

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class NotificationController {

    @Autowired
    private NotificationService service;

    @GetMapping(value = {"/notifications"})
    public Object getData(@RequestParam String bvs) throws IOException, ParseException {
        return service.get(bvs);
    }

    @PostMapping(value = {"/update"})
    public String update(@RequestParam String bvs, @RequestBody List<NotificationRequest> request) throws IOException {
        return service.update(request, bvs);
    }

    @GetMapping(value = {"/bind-version"})
    public Object getBindVersion() throws IOException, ParseException {
        return service.getBindVersion();
    }

    @PostMapping(value = {"/add-bind-version"})
    public String addBindVersion(@RequestBody BindVersionRequest request) throws FileNotFoundException {
        return service.addBindVersion(request);
    }

}
