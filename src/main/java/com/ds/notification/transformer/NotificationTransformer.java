/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.ds.notification.transformer;

import com.ds.notification.entity.Bind7Model;
import com.ds.notification.entity.Bind8Model;
import com.ds.notification.entity.Bind9Model;
import com.ds.notification.model.request.NotificationRequest;
import com.ds.notification.model.response.NotificationResponse;

import java.util.List;

/**
 * Author : Quang Tran Dang
 * Email: trandangquanghust@gmail.com
 * 09/08/2017
 */


public interface NotificationTransformer {

    List<Bind7Model> convertRequestToBind7(List<NotificationRequest> requests);

    List<Bind8Model> convertRequestToBind8(List<NotificationRequest> requests);

    List<Bind9Model> convertRequestToBind9(List<NotificationRequest> requests);

    List<NotificationResponse> convertBind7ToResponse(List<Bind7Model> models);

    List<NotificationResponse> convertBind8ToResponse(List<Bind8Model> models);

    List<NotificationResponse> convertBind9ToResponse(List<Bind9Model> models);

}
