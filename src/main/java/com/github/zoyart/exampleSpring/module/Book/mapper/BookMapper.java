package com.github.zoyart.exampleSpring.module.Book.mapper;

import com.github.zoyart.exampleSpring.module.Book.dto.BookCreateDTO;
import com.github.zoyart.exampleSpring.module.Book.dto.BookPatchDTO;
import com.github.zoyart.exampleSpring.module.Book.dto.BookShowDTO;
import com.github.zoyart.exampleSpring.module.Book.dto.BookUpdateDTO;
import com.github.zoyart.exampleSpring.module.Book.model.Book;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchBookFromDTO(BookPatchDTO bookPatchDTODTO, @MappingTarget Book book);

    void updateBookFromDTO(BookUpdateDTO BookUpdateDTO, @MappingTarget Book book);
    void createBookFromDTO(BookCreateDTO bookCreateDTO, @MappingTarget Book book);

    BookShowDTO toBookShowDTO(Book book);
    List<BookShowDTO> toBookShowDTOs(List<Book> book);
}
