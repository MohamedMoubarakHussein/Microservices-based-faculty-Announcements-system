package com.students.announcements.announcementSys.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.announcements.announcementSys.model.Announcement;
import com.students.announcements.announcementSys.services.KafkaProducer.Producer;


@Service
public class AnnouncementServices {
    private Producer producer;
    
    @Autowired
    public AnnouncementServices(Producer producer ){
        this.producer = producer;
    }
    

    public void send(Announcement announcement){
        this.producer.sendMessage(announcement);
    }


}
