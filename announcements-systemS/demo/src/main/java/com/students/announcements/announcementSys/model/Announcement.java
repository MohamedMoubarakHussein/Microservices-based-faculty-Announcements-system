package com.students.announcements.announcementSys.model;

import java.util.ArrayList;


import lombok.Data;

@Data
public class Announcement {
    private int id;
    private Type type;
    private String announcementTitle;
    private String announcement;
    private String localDate;
    private ArrayList<String> levels;
    
    public enum Type{
        PUBLISH , DELETED , UPDATE
    }

}
