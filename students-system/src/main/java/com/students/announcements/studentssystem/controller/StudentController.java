package com.students.announcements.studentssystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.students.announcements.studentssystem.services.StudentServices;



@RestController
public class StudentController {
    
    private StudentServices studentServices;

    @Autowired
    public StudentController(StudentServices studentServices ){
        this.studentServices = studentServices;

    }

    @GetMapping("/announcements")
    public ResponseEntity<String> getAnnouncements(){
        return this.studentServices.getAnnouncements();
    }

    @GetMapping("/announcement/{id}")
    public ResponseEntity<String> getAnnouncement(@PathVariable int id){
        return this.studentServices.getAnnouncement(id);
    }
 
    /* we use this for example if the student read the message and 
     * need to delete it.
     */
    @DeleteMapping("/announcementdel/{id}")
    public ResponseEntity<String> deleteAnnouncement(@PathVariable int id){
      return this.studentServices.deleteAnnouncement(id);
    }


   
}
