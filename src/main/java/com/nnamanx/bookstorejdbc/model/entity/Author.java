package com.nnamanx.bookstorejdbc.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {

    Long id;
    String author_name;
}
