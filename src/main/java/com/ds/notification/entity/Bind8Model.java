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


public class Bind8Model {

    private String title;

    private List<NewsDetailModel> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<NewsDetailModel> getList() {
        return list;
    }

    public void setList(List<NewsDetailModel> list) {
        this.list = list;
    }

}
