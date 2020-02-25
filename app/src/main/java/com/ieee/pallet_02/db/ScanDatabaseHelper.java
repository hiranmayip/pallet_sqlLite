package com.ieee.pallet_02.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.ieee.pallet_02.model.UserModel;

import java.util.List;


/*
 * File:  ScanDatabaseHelper.java
 *
 * Description:
 *
 * Copyright (c) 2018 by HP Company, 2018, All rights reserved This software is the confidential and
 * proprietary information of HP Company ("Confidential Information").You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license agreement you entered into with HP.
 *
 */
 class ScanDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Pallet.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_LOGIN = "Login";
    private static final String LOGIN_COL_1_EMAILID = "EMAILID";
    private static final String LOGIN_COL_2_PASSWORD = "PASSWORD";
    private static final String LOGIN_COL_3_NICKNAME = "NICKNAME";
    private static final String LOGIN_COL_4_WMONEY = "WMONEY";

    private static final String TABLE_CARDS = "Cards";
    private static final String CARDS_COL_1_NICKNAME = "NICKNAME";
    private static final String CARDS_COL_2_CARDNUM = "CARDNUM";
    private static final String CARDS_COL_3_CVV = "CVV";
    private static final String CARDS_COL_4_EXPIREDATE = "EXPIREDATE";
    private static final String CARDS_COL_5_CARDNAME = "CARDNAME";
    private static final String CARDS_COL_6_CMONEY = "CMONEY";

    private static final String TABLE_PROFILE = "PROFILE";
    private static final String PROFILE_COL_1_NICKNAME = "NICKNAME";
    private static final String PROFILE_COL_2_EMAILID = "EMAILID";
    private static final String PROFILE_COL_3_MOBILENUM = "MOBILENUM";
    private static final String PROFILE_COL_4_DOB = "DOB";
    private static final String PROFILE_COL_5_ADDRESS = "ADDRESS";
    private static final String PROFILE_COL_6_CPASSWORD = "CPASSWORD";
    private static final String PROFILE_COL_7_KYC = "KYC";










    private static final String TAG = "ScanDatabaseHelper";

    public static final String CREATE_LOGIN_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_LOGIN + "(" + LOGIN_COL_1_EMAILID + "TEXT NOT NULL, "
            + LOGIN_COL_2_PASSWORD + " TEXT NOT NULL, "
            + LOGIN_COL_3_NICKNAME + " TEXT PRIMARY KEY, " + LOGIN_COL_4_WMONEY + " INTEGER" + ")";
    public static final String CREATE_CARDS_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_CARDS + "(" + CARDS_COL_1_NICKNAME + "TEXT NOT NULL, "+ CARDS_COL_2_CARDNUM + " INTEGER, " + CARDS_COL_3_CVV +" INTEGER, "
            + CARDS_COL_4_EXPIREDATE+" INTEGER, "+CARDS_COL_5_CARDNAME + "TEXT NOT NULL, "+CARDS_COL_6_CMONEY+" INTEGER, "
            +"FOREIGN KEY(" + CARDS_COL_1_NICKNAME + ") REFERENCES " + TABLE_LOGIN + LOGIN_COL_3_NICKNAME +")";
    public static final String CREATE_PROFILE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_PROFILE + "(" +PROFILE_COL_1_NICKNAME+ "TEXT NOT NULL, "+PROFILE_COL_2_EMAILID+ "TEXT NOT NULL, "+PROFILE_COL_3_MOBILENUM+ "INTEGER, "
            + PROFILE_COL_4_DOB +"TEXT NOT NULL, " +PROFILE_COL_5_ADDRESS+"TEXT NOT NULL, "
            + PROFILE_COL_6_CPASSWORD+"INTEGER, "+PROFILE_COL_7_KYC+"BOOLEAN, "+"FOREIGN KEY(" + PROFILE_COL_1_NICKNAME + ") REFERENCES "+
            TABLE_LOGIN + LOGIN_COL_3_NICKNAME +  ")";


//
//    public static final String CREATE_SCANTICKET_TABLE = "CREATE TABLE IF NOT EXISTS "
//            + TABLE_TICKET + "(" + TICKET_COL_1_TICKETID  + " PRIMARY KEY, "
//            + TICKET_COL_2_EMPID + " TEXT NOT NULL, " + TICKET_COL_3_EMPNAME + " TEXT NOT NULL, "+TICKET_COL_4_IPADDRESS+
//            " TEXT NOT NULL" +  ")";
//    public static final String CREATE_SUBTICKET_TABLE = "CREATE TABLE IF NOT EXISTS "
//            + TABLE_SUBTICKET+ "(" + SUBTICKET_COL_1_SUBTICKETID  + " PRIMARY KEY, "
//            + SUBTICKET_COL_2_TICKETID + " TEXT NOT NULL, " + SUBTICKET_COL_3_DOCNAME + " TEXT NOT NULL, "+
//            SUBTICKET_COL_4_TIMESTAMP + " TEXT NOT NULL, "+ SUBTICKET_COL_5_DOCFORMAT + " TEXT NOT NULL, "+
//            SUBTICKET_COL_4_TIMESTAMP + " TEXT NOT NULL, "+ SUBTICKET_COL_5_DOCFORMAT + " TEXT NOT NULL, "+
//            SUBTICKET_COL_4_TIMESTAMP + " TEXT NOT NULL, "+ SUBTICKET_COL_5_DOCFORMAT + " TEXT NOT NULL, "+
//            SUBTICKET_COL_6_SCANSIZE  + " TEXT NOT NULL, "+ SUBTICKET_COL_7_DARKNESSADJ + " TEXT NOT NULL, "+
//            SUBTICKET_COL_8_ORIENTATION + " TEXT NOT NULL, "+ SUBTICKET_COL_9_TEXTPHOTOOPT  + " TEXT NOT NULL, "+
//            SUBTICKET_COL_10_BACKCLEANUP + " TEXT NOT NULL, "+ SUBTICKET_COL_11_BLANKIMAGEREM + " TEXT NOT NULL, "+
//            SUBTICKET_COL_12_CONTRAST + " TEXT NOT NULL, "+ SUBTICKET_COL_13_PROGDIALOG  + " TEXT NOT NULL, "+
//            SUBTICKET_COL_14_COLORDROPOUT + " TEXT NOT NULL, "+SUBTICKET_COL_15_MEDIAWEIGHTADJ  + " TEXT NOT NULL, "+
//            SUBTICKET_COL_16_SHARPADJ + " TEXT NOT NULL, "+ SUBTICKET_COL_17_RESOLUTIONTYPE+ " TEXT NOT NULL, "+
//            SUBTICKET_COL_18_CUSTOMW  + " TEXT NOT NULL, "+ SUBTICKET_COL_19_TRANMISSIONMODE+ " TEXT NOT NULL, "+
//            SUBTICKET_COL_20_CUSTOMLENGH + " TEXT NOT NULL, "+SUBTICKET_COL_21_MISFEEDDETECT  + " TEXT NOT NULL, "+
//            SUBTICKET_COL_22_DOCFORMAT + " TEXT NOT NULL, "+ SUBTICKET_COL_23_CROPMODE + " TEXT NOT NULL, "+
//            SUBTICKET_COL_24_DESTINATION  + " TEXT NOT NULL, "+ SUBTICKET_COL_25_JOBASSMODE  + " TEXT NOT NULL, "+
//            SUBTICKET_COL_26_DESTINATION + " TEXT NOT NULL, "+ SUBTICKET_COL_27_OUTPUTQ + " TEXT NOT NULL, "+
//            SUBTICKET_COL_28_PLEX  + " TEXT NOT NULL, "+ SUBTICKET_COL_29_DESTINATION + " TEXT NOT NULL, "+
//            SUBTICKET_COL_30_MEDIASOURCE + " TEXT NOT NULL, "+  SUBTICKET_COL_31_COLORMODE + " TEXT NOT NULL, "+
//            SUBTICKET_COL_32_PDFCOMPRESSION  + " TEXT NOT NULL, "+ SUBTICKET_COL_33_XPSCOMPRESSION + " TEXT NOT NULL, "+
//            SUBTICKET_COL_34_DESTINATION+ " TEXT NOT NULL, "+ SUBTICKET_COL_35_OCRL + " TEXT NOT NULL, "+
//            SUBTICKET_COL_36_TIFFCOMPRESSION  + " TEXT NOT NULL, "+ SUBTICKET_COL_37_TICKETID + " TEXT NOT NULL, "+" INT, "
//            + "FOREIGN KEY(" + SUBTICKET_COL_37_TICKETID + ") REFERENCES "
//            + TABLE_TICKET + TICKET_COL_1_TICKETID + " )";


    public ScanDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_SCANTICKET_TABLE);
//        db.execSQL(CREATE_SUBTICKET_TABLE);
        db.execSQL(CREATE_LOGIN_TABLE);
//        db.execSQL(CREATE_CARDS_TABLE);
//        db.execSQL(CREATE_PROFILE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS "+TABLE_TICKET);
//        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SUBTICKET);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_LOGIN);
//        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CARDS);
//        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PROFILE);
        onCreate(db);
    }


    boolean registerUser(String email, String password, String nickName){
        SQLiteDatabase db = null;
        boolean result = true;

        try{
            db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put(LOGIN_COL_1_EMAILID,email);
            contentValues.put(LOGIN_COL_2_PASSWORD,password);
            contentValues.put(LOGIN_COL_3_NICKNAME,nickName);

            long insertion_result = db.insert(TABLE_LOGIN, null, contentValues);
            result = insertion_result != -1;

        }catch (Exception e){
            Log.e(TAG," Exception while registering the user "+e.getMessage());
        }finally {
            if(db != null) {
                db.close();
            }
        }

        return result;
    }

    String getCredentials(String email){

        String password = null;
        SQLiteDatabase db = null;

        try{
            db = this.getReadableDatabase();
            Cursor cursor = db.query(TABLE_LOGIN,new String[]{LOGIN_COL_2_PASSWORD},LOGIN_COL_1_EMAILID,
                    new String[]{email},null,null,null);

            while(cursor.moveToNext()) {
                int index;
                Log.i(TAG,"cursor run in getCredentials");
                index = cursor.getColumnIndexOrThrow(LOGIN_COL_2_PASSWORD);
                 password = cursor.getString(index);
            }


        }catch (Exception e){
            Log.e(TAG," Exception while getting credentials from the user "+e.getMessage());
        }finally {
            if(db != null) {
                db.close();
            }
        }

        return password;
    }


//    boolean insertScanTikcet(TicketItem ticketItem) {
//        SQLiteDatabase db= null;
//        boolean finalRes = false;
//        try {
//           db = this.getWritableDatabase();
//            ContentValues contentValues = new ContentValues();
////            contentValues.put(TICKET_COL_1_TICKET, ticketItem.);
////            contentValues.put(COL_3, empname);
////            contentValues.put(COL_4, ipaddress);
//            long result = db.insert(TABLE_TICKET, null, contentValues);
//            finalRes = result != -1;
//
//        }
//        catch(Exception e){
//            Log.e(TAG, "Excepion caught"+ e.getMessage());
//        }
//        finally{
//            if(db != null) {
//                db.close();
//            }
//        }
//         return  finalRes;
//
//    }
//
//     List<TicketItem> getAllScanTickets() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        //Cursor res = db.rawQuery("select * from "+TABLE_MAIN,null);
//        return null;
//    }
//    TicketItem getScanTicket(Integer id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        //Cursor res = db.rawQuery("select * from "+TABLE_MAIN,null);
//        return null;
//    }
//
//     boolean updateScanTicket(TicketItem ticketItem) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
////        contentValues.put(COL_1,ticketid);
////        contentValues.put(COL_2,empid);
////        contentValues.put(COL_3,empname);
////        contentValues.put(COL_4,ipaddress);
////        db.update(TABLE_MAIN, contentValues, "ID = ?",new String[] { ticketid });
//        return true;
//    }
//
//     boolean  deleteScanTicket (Integer id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        //return db.delete(TABLE_MAIN, "ID = ?",new String[] {id});
//        return false;
//    }
//    boolean deleteAllScanTicket(){
//        SQLiteDatabase db = this.getWritableDatabase();
////        db.execSQL("DROP TABLE IF EXISTS "+TABLE_MAIN);
////        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SUB);
//        onCreate(db);
//        return true;
//
//    }
}
