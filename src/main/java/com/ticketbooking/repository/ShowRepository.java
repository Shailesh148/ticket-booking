package com.ticketbooking.repository;

import com.ticketbooking.entity.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, Integer> {

//    @Query("select s from show_entity s where u.movie_id.movie_id = ?1")
    List<ShowEntity> findByMovieMovieId(int id);
}
