package com.students.announcements.studentssystem.services.KafkaConsumer;

import com.students.announcements.studentssystem.model.Announcement.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.students.announcements.studentssystem.model.Announcement;
import com.students.announcements.studentssystem.services.StudentServices;


@Component
public class Consumer {
    private  final String topic = "${topic.name}";
    private StudentServices studentServices;
    private Gson gson;

    @Autowired
    public Consumer(StudentServices studentServices , Gson gson){
        this.studentServices = studentServices;
        this.gson = gson;
    }


    @KafkaListener(topics = topic)
    public void consume(String message){
        Announcement  announcement = this.gson.fromJson(message, Announcement.class);
        if(announcement.getType() == Type.PUBLISH){
            announcement.setId(0);
            this.studentServices.saveAnnouncement(announcement);

        }else if(announcement.getType() == Type.DELETED){
            this.studentServices.deleteAnnouncement(announcement.getId());
        }else if(announcement.getType() == Type.UPDATE){
            this.studentServices.updateAnnouncement(announcement);
        }
    }


}
