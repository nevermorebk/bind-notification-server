/***************************************************************************
 * Copyright HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.ds.notification.transformer;

import com.ds.notification.entity.*;
import com.ds.notification.model.request.NotificationRequest;
import com.ds.notification.model.response.NotificationResponse;

import java.util.List;

/**
 * Author : Quang Tran Dang
 * Email: trandangquanghust@gmail.com
 * 09/08/2017
 */


public interface NotificationTransformer {

    BindVersion convertRequestToBindVersion(List<NotificationRequest> requests, String version);

    List<NotificationResponse> convertBindDataToResponse(List<BindData> models);


}
