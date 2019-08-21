package com.example.friendnotes.repository;

import com.example.friendnotes.model.Intersactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntersactionsRepository extends JpaRepository<Intersactions, Long> {
}
