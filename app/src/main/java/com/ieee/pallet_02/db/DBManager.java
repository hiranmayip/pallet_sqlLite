package com.ieee.pallet_02.db;


import android.content.Context;
import android.database.SQLException;
import com.hp.pegasus.pushscan.models.ApplicationModel;
import com.hp.pegasus.pushscan.models.dbmodel.TicketItem;

import java.util.List;

/*
 * File:  DBManager.java
 *
 * Description:
 *
 * Copyright (c) 2018 by HP Company, 2018, All rights reserved This software is the confidential and
 * proprietary information of HP Company ("Confidential Information").You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license agreement you entered into with HP.
 *
 */
public class DBManager {
    private  ScanDatabaseHelper dbHelper;
   private  static DBManager dbManager;
    private final Context context;



    private  DBManager() {
        context = ApplicationModel.getInstance().getApplicationContext();
    }

    public static synchronized  DBManager getInstance(){
         if(dbManager == null){
             dbManager= new DBManager();
         }
         return dbManager;
    }


    public  synchronized  void  open () throws SQLException {
        dbHelper = new ScanDatabaseHelper(context);

    }

    public synchronized void close (){
        dbHelper.close();
    }



}
