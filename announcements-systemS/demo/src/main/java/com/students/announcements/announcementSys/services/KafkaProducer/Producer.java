package com.students.announcements.announcementSys.services.KafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.students.announcements.announcementSys.model.Announcement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Producer {
    
    private  final String topic = "announcement.sys";
    private KafkaTemplate<String , String> template;
    private Gson gson;
    
    @Autowired
    public Producer(KafkaTemplate<String, String> template , Gson gson){
        this.template = template;
        this.gson = gson;
    }


    public void sendMessage(Announcement announcement){
        String message = gson.toJson(announcement);
        this.template.send(topic , message);
        log.info("the offer "+message+" sended");
    }


}
