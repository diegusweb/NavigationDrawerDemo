package com.example.diegorueda.drawernavigation.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego.rueda on 9/3/2015.
 */
public class Contact {
    private String mName;
    private boolean mOnline;

    public Contact(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public boolean ismOnline() {
        return mOnline;
    }

    public void setmOnline(boolean mOnline) {
        this.mOnline = mOnline;
    }

    private static int lastContactId = 0;

    public static List<Contact> createContactList(int numContacts){
        List<Contact> contacts = new ArrayList<>();

        for (int i=1; i <= numContacts; i++){
            contacts.add(new Contact("Person " + ++lastContactId, i <= numContacts / 2));
        }
        return contacts;
    }

}
