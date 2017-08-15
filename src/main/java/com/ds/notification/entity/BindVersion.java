/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.ds.notification.entity;

import java.util.List;

/**
 * Author : Quang Tran Dang
 * Email: trandangquanghust@gmail.com
 * 15/08/2017
 */


public class BindVersion {

    public String version;
    public List<BindData> data;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<BindData> getData() {
        return data;
    }

    public void setData(List<BindData> data) {
        this.data = data;
    }
}
