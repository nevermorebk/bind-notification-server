/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.ds.notification.model.request;

/**
 * Author : Quang Tran Dang
 * Email: trandangquanghust@gmail.com
 * 15/08/2017
 */


public class BindVersionRequest {

    private Integer type;
    private String version;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
