/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.ds.notification.service.impl;

import com.ds.notification.entity.*;
import com.ds.notification.model.request.BindVersionRequest;
import com.ds.notification.model.request.NotificationRequest;
import com.ds.notification.service.NotificationService;
import com.ds.notification.transformer.NotificationTransformer;
import com.google.gson.Gson;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Author : Quang Tran Dang
 * Email: trandangquanghust@gmail.com
 * 09/08/2017
 */

@Component
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationTransformer transformer;

    private CommonNotification notification;
    private String filePath = "/home/trungdovan/notification.json";
    private Gson gson = new Gson();

    public NotificationServiceImpl() throws FileNotFoundException {
        FileReader reader = new FileReader(filePath);
        notification = gson.fromJson(reader, CommonNotification.class);
    }

    @Override
    public Object get(String bvs) throws IOException, ParseException {
        List<BindVersion> bind = notification.getNews().stream().filter((item)-> item.getVersion().equals(bvs)).collect(Collectors.toList());
        return transformer.convertBindDataToResponse(bind.get(0).getData());
    }

    @Override
    public String update(List<NotificationRequest> request, String bvs) throws IOException {

        List<BindVersion> bind = notification.getNews().stream().map(o -> {
            if(o.getVersion().equals(bvs)){
                return transformer.convertRequestToBindVersion(request, bvs);
            }
            return o;
        }).collect(Collectors.toList());
        notification.setNews(bind);
        return writeFile(notification);
    }

    @Override
    public Object getBindVersion() throws IOException, ParseException {
        return convertToBindVersion(notification.getNews());
    }

    @Override
    public String addBindVersion(BindVersionRequest request) throws FileNotFoundException {
        BindVersion bindVersion = new BindVersion();
        bindVersion.setVersion(request.getVersion());
        bindVersion.setData(new ArrayList<>());
        notification.getNews().add(bindVersion);
        return writeFile(notification);
    }

    private String writeFile(CommonNotification notification) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filePath);
        writer.print("");
        writer.print(gson.toJson(notification));
        writer.close();
        return "OK";
    }

    private List<String> convertToBindVersion(List<BindVersion> versions){
        Function<BindVersion, String> func = (item) -> {
            return item.getVersion();
        };
        return versions.stream().map(func).collect(Collectors.toList());
    }

    // This is customized each bind version

/*    private List<Bind7Model> convertRequestToBind7(List<NotificationRequest> requests) {

        List<Bind7Model> bind7Models = new ArrayList<>();

        for(int i =0; i < requests.size(); i ++){
            Bind7Model bind7Model = new Bind7Model();
            bind7Model.setTitle(requests.get(i).getTitle());
            List<NewsDetail> list = new ArrayList<>();
            list.add(convertRequestToNews(requests.get(i)));

            for(int j =i+1; j < requests.size(); j ++){
                if(requests.get(i).getTitle().equals(requests.get(j).getTitle())){
                    list.add(convertRequestToNews(requests.get(j)));
                    if(i==requests.size()-2){
                        bind7Model.setList(list);
                        bind7Models.add(bind7Model);
                        return bind7Models;
                    }
                }else {
                    break;
                }
            }
            bind7Model.setList(list);
            bind7Models.add(bind7Model);
        }
        return bind7Models;

    }*/


}
