package com.aynavil.springbootaws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aynavil.springbootaws.entity.Book;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book,Long>{

}
