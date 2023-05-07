package com.students.announcements.announcementSys.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.students.announcements.announcementSys.model.Announcement;
import com.students.announcements.announcementSys.services.AnnouncementServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AnnnouncementController {
    
    private AnnouncementServices AnnouncementService;

    @Autowired
    public AnnnouncementController(AnnouncementServices announcementService ){
        this.AnnouncementService = announcementService;

    }

    

    @PostMapping("/publishAnnouncement")
    public ResponseEntity<String> publish(@RequestBody Announcement announcement){
        log.info("Announcement publish request has been recived\n" + announcement);
        announcement.setType(Announcement.Type.PUBLISH);
        this.AnnouncementService.send(announcement);
        return ResponseEntity.ok().body("Announcement publish request has been recived: \n"+announcement);
    }

    @DeleteMapping("/deleteAnnouncement")
    public ResponseEntity<String> delete(@RequestBody Announcement announcement){
        log.info("Announcement delete request has been recived\n" + announcement);
        announcement.setType(Announcement.Type.DELETED);
        this.AnnouncementService.send(announcement);
        
        return ResponseEntity.ok().body("Announcement delete request has been recived:  \n"+announcement);
            
    }

    @PutMapping("/updateAnnouncement")
    public ResponseEntity<String> update(@RequestBody Announcement announcement){
        log.info("Announcement update request has been recived \n" + announcement);
        announcement.setType(Announcement.Type.UPDATE);
        this.AnnouncementService.send(announcement);
        
        return ResponseEntity.ok().body("Announcement update request has been recived: \n"+announcement);
        
    }


   
}
