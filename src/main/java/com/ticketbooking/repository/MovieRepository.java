package com.ticketbooking.repository;

import com.ticketbooking.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {
    Movies findByTitle(String title);
}
