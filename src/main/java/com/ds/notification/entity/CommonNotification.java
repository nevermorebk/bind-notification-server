/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.ds.notification.entity;

import java.util.List;

/**
 * Author : Quang Tran Dang
 * Email: trandangquanghust@gmail.com
 * 09/08/2017
 */

public class CommonNotification {

    private AdModel ad;
    private List<Bind7Model> news_7;
    private List<Bind8Model> news_8;
    private List<Bind9Model> news_9;
    private List<ScheduleModel> schedule;

    public AdModel getAd() {
        return ad;
    }

    public void setAd(AdModel ad) {
        this.ad = ad;
    }

    public List<Bind7Model> getNews_7() {
        return news_7;
    }

    public void setNews_7(List<Bind7Model> news_7) {
        this.news_7 = news_7;
    }

    public List<Bind8Model> getNews_8() {
        return news_8;
    }

    public void setNews_8(List<Bind8Model> news_8) {
        this.news_8 = news_8;
    }

    public List<Bind9Model> getNews_9() {
        return news_9;
    }

    public void setNews_9(List<Bind9Model> news_9) {
        this.news_9 = news_9;
    }

    public List<ScheduleModel> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<ScheduleModel> schedule) {
        this.schedule = schedule;
    }
}
