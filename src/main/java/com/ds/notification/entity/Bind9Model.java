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


public class Bind9Model {

    private String title;

    private List<NewsDetail> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<NewsDetail> getList() {
        return list;
    }

    public void setList(List<NewsDetail> list) {
        this.list = list;
    }

}
