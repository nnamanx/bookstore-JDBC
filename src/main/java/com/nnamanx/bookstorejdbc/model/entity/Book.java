package com.nnamanx.bookstorejdbc.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {

    Long id;
    String title;
    String author;
    @Builder.Default
    Boolean status = false;
}
