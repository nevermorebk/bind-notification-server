/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.ds.notification.service;

import com.ds.notification.model.request.NotificationRequest;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

/**
 * Author : Quang Tran Dang
 * Email: trandangquanghust@gmail.com
 * 09/08/2017
 */


public interface NotificationService {

    Object get(Integer bvs) throws IOException, ParseException;
    String update(List<NotificationRequest> request, Integer bvs) throws IOException;

}
