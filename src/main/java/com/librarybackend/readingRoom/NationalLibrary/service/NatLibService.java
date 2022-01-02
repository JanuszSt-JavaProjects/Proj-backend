package com.librarybackend.readingRoom.NationalLibrary.service;

import com.librarybackend.readingRoom.NationalLibrary.apiClient.NatLibClient;
import com.librarybackend.readingRoom.NationalLibrary.domain.NatLibBookDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Data
@Service
public class NatLibService {

    @Autowired
    NatLibClient natLibClient;

    public List<NatLibBookDto> getBooks(String author, String title) {
        if (author == null & title == null) {
            return Collections.emptyList();
        }
        natLibClient.setAuthor(author);
        natLibClient.setTitle(title);
        System.out.println(natLibClient);
        return natLibClient.getBookList();
    }
}
