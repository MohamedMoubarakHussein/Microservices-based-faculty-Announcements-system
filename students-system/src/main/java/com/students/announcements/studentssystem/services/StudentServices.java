package com.students.announcements.studentssystem.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.students.announcements.studentssystem.model.Announcement;
import com.students.announcements.studentssystem.repository.AnnouncementRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServices {
    private AnnouncementRepository announcementRepository;
    
    @Autowired
    public StudentServices(AnnouncementRepository announcementRepository ){
        this.announcementRepository = announcementRepository;
    }
    

    public void saveAnnouncement(Announcement announcement){
        log.info("This announcement recived from kafka \n"+announcement);
        this.announcementRepository.save(announcement);
        
    }

    public ResponseEntity<String> getAnnouncement(int id){
        Announcement announcement = this.announcementRepository.findById(id).orElse(null);
        if(announcement == null){
            return ResponseEntity.ok().body("There is no announcement has id = "+id);
        }else{
            return ResponseEntity.ok().body("The announcement is \n"+ announcement);
        }
        
    }



    public ResponseEntity<String> getAnnouncements(){
        List<Announcement> announcement =this.announcementRepository.findAll();
        String allAnouncements = "";
        for(int i = 0 ; i < announcement.size() ; i++){
            allAnouncements += announcement.get(i)+"\n";
        }
        return ResponseEntity.ok().body("we found "+announcement.size()+" announcements:\n"+allAnouncements);
    
    }

    public ResponseEntity<String> deleteAnnouncement(int id){
        log.info("Announcement Delete request has been recived On id = "+id);
        this.announcementRepository.deleteById(id);
        return ResponseEntity.ok().body("Deleted request has been submited successfuly");
        
    }

    public void updateAnnouncement(Announcement announcement){
        log.info("Announcement update request has been recived On id = "+announcement.getId());
       
        Announcement newAnnouncement = this.announcementRepository.findById(announcement.getId()).orElse(null);
        if(newAnnouncement != null){
            newAnnouncement.setAnnouncement(announcement.getAnnouncement());
            newAnnouncement.setAnnouncementTitle(announcement.getAnnouncementTitle());
            newAnnouncement.setLevels(announcement.getLevels());
            newAnnouncement.setLocalDate(announcement.getLocalDate());
            this.saveAnnouncement(newAnnouncement);
        }
        
    }


}
