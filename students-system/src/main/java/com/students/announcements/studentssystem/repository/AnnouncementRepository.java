package com.students.announcements.studentssystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.announcements.studentssystem.model.Announcement;

@Repository
public interface AnnouncementRepository  extends JpaRepository<Announcement , Integer> {
    
}
