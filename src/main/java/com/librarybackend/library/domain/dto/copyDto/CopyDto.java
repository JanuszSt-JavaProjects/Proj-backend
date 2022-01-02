package com.librarybackend.library.domain.dto.copyDto;

import com.librarybackend.library.domain.Status;
import lombok.Data;

@Data
public class CopyDto {
    private long id;
    private String signature;
    private Status status;
}
