/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.ds.notification.service.impl;

import com.ds.notification.entity.*;
import com.ds.notification.model.request.NotificationRequest;
import com.ds.notification.model.response.NotificationResponse;
import com.ds.notification.service.NotificationService;
import com.ds.notification.transformer.NotificationTransformer;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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

    private CommonNotification cache = new CommonNotification();
    private String filePath = "/home/trungdovan/notification.json";
    private Gson gson = new Gson();

    @Override
    public Object get(Integer bvs) throws IOException, ParseException {
        FileReader reader = new FileReader(filePath);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        CommonNotification notification = gson.fromJson(jsonObject.toJSONString(), CommonNotification.class);
        cache = notification;
        switch (bvs){
            case 7:
                return transformer.convertBind7ToResponse(notification.getNews_7());
            case 8:
                return transformer.convertBind8ToResponse(notification.getNews_8());
            case 9:
                return transformer.convertBind9ToResponse(notification.getNews_9());
            default: return null;
        }
    }

    @Override
    public String update(List<NotificationRequest> request, Integer bvs) throws IOException {
        switch (bvs){
            case 7:
                cache.setNews_7(transformer.convertRequestToBind7(request));
                break;
            case 8:
                cache.setNews_8(transformer.convertRequestToBind8(request));
                break;
            case 9:
                cache.setNews_9(transformer.convertRequestToBind9(request));
                break;
        }
        PrintWriter writer = new PrintWriter(filePath);
        writer.print("");
        writer.print(gson.toJson(cache));
        writer.close();
        return "OK";
    }

    // This is customized each bind version

/*    private List<Bind7Model> convertRequestToBind7(List<NotificationRequest> requests) {

        List<Bind7Model> bind7Models = new ArrayList<>();

        for(int i =0; i < requests.size(); i ++){
            Bind7Model bind7Model = new Bind7Model();
            bind7Model.setTitle(requests.get(i).getTitle());
            List<NewsDetailModel> list = new ArrayList<>();
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
