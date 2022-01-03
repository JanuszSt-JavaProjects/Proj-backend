package com.librarybackend.library.repository;


import com.librarybackend.library.domain.Book;
import com.librarybackend.library.domain.Copy;
import com.librarybackend.library.domain.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {

    LinkedList<Copy> findAllByBook_IdAndStatus(long book_id, Status status);

    @Override
    List<Copy> findAll();

}
