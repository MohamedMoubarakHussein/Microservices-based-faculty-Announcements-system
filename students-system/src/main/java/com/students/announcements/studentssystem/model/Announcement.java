package com.students.announcements.studentssystem.model;


import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //   deserialize    json -> object   serialize   object -> json
    // @Expose(serialize = true , deserialize = false )
    private int id;
    private Type type;
    private String announcementTitle;
    private String announcement;
    private String localDate;
    private ArrayList<String> levels;
    
  

    public enum Type{
        PUBLISH , DELETED , UPDATE
    }

    @Override
    public String toString(){
        return  "id: "+this.id+
                "\nTitle: "+this.announcementTitle+
                "\nlocalDate: "+this.localDate+
                "\naffected levels: "+this.levels+
                "\nannouncement: "+this.announcement;
                
    }
}
