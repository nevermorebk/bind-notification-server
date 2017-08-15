/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.ds.notification.transformer.impl;

import com.ds.notification.entity.*;
import com.ds.notification.model.request.NotificationRequest;
import com.ds.notification.model.response.NotificationResponse;
import com.ds.notification.transformer.NotificationTransformer;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Author : Quang Tran Dang
 * Email: trandangquanghust@gmail.com
 * 09/08/2017
 */

@Component
public class NotificationTransformerImpl implements NotificationTransformer{

    @Override
    public BindVersion convertRequestToBindVersion(List<NotificationRequest> requests, String version) {
        Function<NotificationRequest, String> func = (item) -> {
            return item.getTitle();
        };

        List<String> list = requests.stream().map(func).collect(Collectors.toList());
        Set<String> set = new HashSet<>(list);

        List<BindData> bindData = new ArrayList<>();

        set.stream().forEach((item) -> {
            BindData data = new BindData();
            data.setTitle(item);
            List<NewsDetail> models = new ArrayList<>();
            requests.stream().forEach((i) -> {
                if(i.getTitle().equals(item)){
                    models.add(convertRequestToNews(i));
                }
            });
            data.setList(models);
            bindData.add(data);
        });

        BindVersion bindVersion = new BindVersion();
        bindVersion.setVersion(version);
        bindVersion.setData(bindData);

        return bindVersion;
    }

    private NewsDetail convertRequestToNews(NotificationRequest request){
        NewsDetail news = new NewsDetail();
        news.setTitle(request.getSubtitle());
        news.setContent(request.getContent());
        news.setDate(request.getDate());
        news.setExt_link(request.getExt_link());
        news.setId(request.getId());
        news.setIs_show(request.getIs_show());
        return news;
    }

    @Override
    public List<NotificationResponse> convertBindDataToResponse(List<BindData> bindData) {
        List<NotificationResponse> responses = new LinkedList<>();

        for(BindData data : bindData){
            for (NewsDetail news : data.getList()){
                NotificationResponse response = new NotificationResponse();
                response.setTitle(data.getTitle());
                response.setContent(news.getContent());
                response.setDate(news.getDate());
                response.setSubtitle(news.getTitle());
                response.setExt_link(news.getExt_link());
                response.setId(news.getId());
                response.setIs_show(news.getIs_show());
                responses.add(response);
            }
        }
        return responses;
    }

}
