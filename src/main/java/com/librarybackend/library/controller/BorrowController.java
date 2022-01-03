package com.librarybackend.library.controller;


import com.librarybackend.library.domain.Borrow;
import com.librarybackend.library.domain.dto.borrowDto.BorrowDto;
import com.librarybackend.library.mapper.BorrowMapper;
import com.librarybackend.library.service.BorrowService;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("library/borrows")
public class BorrowController {

    BorrowService borrowService;
    BorrowMapper borrowMapper;

    public BorrowController(BorrowService borrowService, BorrowMapper borrowMapper) {
        this.borrowService = borrowService;
        this.borrowMapper = borrowMapper;
    }

    @PostMapping
    public BorrowDto create(@RequestBody BorrowDto borrowDto) {

        Borrow borrow = borrowMapper.mapBorrowDtoToBorrow(borrowDto);
        return borrowMapper.mapBorrowToBorrowDto(borrowService.save(borrow));

    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        borrowService.remove(id);
    }

    @PutMapping
    public BorrowDto update(@RequestBody BorrowDto borrowDto) {
        System.out.println(borrowDto);

        Borrow borrow = borrowMapper.mapBorrowDtoToBorrow(borrowDto);

        return borrowMapper.mapBorrowToBorrowDto(borrowService.update(borrow));
    }

    @GetMapping
    public Set<BorrowDto> getAll() {
        Set<BorrowDto> borrowDtos = new HashSet<>();
        borrowService.getAll().forEach(borrow -> borrowDtos.add(borrowMapper.mapBorrowToBorrowDto(borrow)));

        return borrowDtos;
    }

    @GetMapping("/{id}")
    public BorrowDto getOne(@PathVariable long id) {
        return borrowMapper.mapBorrowToBorrowDto(borrowService.getOne(id));
    }

}
