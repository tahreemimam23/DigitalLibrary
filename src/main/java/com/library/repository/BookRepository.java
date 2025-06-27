package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {

}
