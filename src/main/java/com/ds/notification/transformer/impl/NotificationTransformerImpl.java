/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.ds.notification.transformer.impl;

import com.ds.notification.entity.Bind7Model;
import com.ds.notification.entity.Bind8Model;
import com.ds.notification.entity.Bind9Model;
import com.ds.notification.entity.NewsDetailModel;
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
    public List<Bind7Model> convertRequestToBind7(List<NotificationRequest> requests) {
        Function<NotificationRequest, String> func = (item) -> {
            return item.getTitle();
        };

        List<String> list = requests.stream().map(func).collect(Collectors.toList());
        Set<String> set = new HashSet<>(list);

        List<Bind7Model> bind7Models = new ArrayList<>();

        set.stream().forEach((item) -> {
            Bind7Model bind7Model = new Bind7Model();
            bind7Model.setTitle(item);
            List<NewsDetailModel> models = new ArrayList<>();
            requests.stream().forEach((i) -> {
                if(i.getTitle().equals(item)){
                    models.add(convertRequestToNews(i));
                }
            });
            bind7Model.setList(models);
            bind7Models.add(bind7Model);

        });

        return bind7Models;
    }

    @Override
    public List<Bind8Model> convertRequestToBind8(List<NotificationRequest> requests) {
        Function<NotificationRequest, String> func = (item) -> {
            return item.getTitle();
        };

        List<String> list = requests.stream().map(func).collect(Collectors.toList());
        Set<String> set = new HashSet<>(list);

        List<Bind8Model> bind8Models = new ArrayList<>();

        set.stream().forEach((item) -> {
            Bind8Model bind8Model = new Bind8Model();
            bind8Model.setTitle(item);
            List<NewsDetailModel> models = new ArrayList<>();
            requests.stream().forEach((i) -> {
                if(i.getTitle().equals(item)){
                    models.add(convertRequestToNews(i));
                }
            });
            bind8Model.setList(models);
            bind8Models.add(bind8Model);

        });

        return bind8Models;
    }

    @Override
    public List<Bind9Model> convertRequestToBind9(List<NotificationRequest> requests) {
        Function<NotificationRequest, String> func = (item) -> {
            return item.getTitle();
        };

        List<String> list = requests.stream().map(func).collect(Collectors.toList());
        Set<String> set = new HashSet<>(list);

        List<Bind9Model> bind9Models = new ArrayList<>();

        set.stream().forEach((item) -> {
            Bind9Model bind9Model = new Bind9Model();
            bind9Model.setTitle(item);
            List<NewsDetailModel> models = new ArrayList<>();
            requests.stream().forEach((i) -> {
                if(i.getTitle().equals(item)){
                    models.add(convertRequestToNews(i));
                }
            });
            bind9Model.setList(models);
            bind9Models.add(bind9Model);

        });

        return bind9Models;
    }

    private NewsDetailModel convertRequestToNews(NotificationRequest request){
        NewsDetailModel news = new NewsDetailModel();
        news.setTitle(request.getSubtitle());
        news.setContent(request.getContent());
        news.setDate(request.getDate());
        news.setExt_link(request.getExt_link());
        news.setId(request.getId());
        news.setIs_show(request.getIs_show());
        return news;
    }

    @Override
    public List<NotificationResponse> convertBind7ToResponse(List<Bind7Model> models) {
        List<NotificationResponse> responses = new LinkedList<>();

        for(Bind7Model model : models){
            for (NewsDetailModel news : model.getList()){
                NotificationResponse response = new NotificationResponse();
                response.setTitle(model.getTitle());
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

    @Override
    public List<NotificationResponse> convertBind8ToResponse(List<Bind8Model> models) {
        List<NotificationResponse> responses = new ArrayList<>();

        for(Bind8Model model : models){
            for (NewsDetailModel news : model.getList()){
                NotificationResponse response = new NotificationResponse();
                response.setTitle(model.getTitle());
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

    @Override
    public List<NotificationResponse> convertBind9ToResponse(List<Bind9Model> models) {
        List<NotificationResponse> responses = new ArrayList<>();

        for(Bind9Model model : models){
            for (NewsDetailModel news : model.getList()){
                NotificationResponse response = new NotificationResponse();
                response.setTitle(model.getTitle());
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
