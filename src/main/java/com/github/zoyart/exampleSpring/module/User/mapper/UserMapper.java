package com.github.zoyart.exampleSpring.module.User.mapper;

import com.github.zoyart.exampleSpring.module.Book.mapper.BookMapper;
import com.github.zoyart.exampleSpring.module.User.dto.UserCreateDTO;
import com.github.zoyart.exampleSpring.module.User.dto.UserPatchDTO;
import com.github.zoyart.exampleSpring.module.User.dto.UserShowDTO;
import com.github.zoyart.exampleSpring.module.User.dto.UserUpdateDTO;
import com.github.zoyart.exampleSpring.module.User.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", uses = BookMapper.class)
public interface UserMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchUserFromDTO(UserPatchDTO userPatchDTO, @MappingTarget User user);

    void updateUserFromDTO(UserUpdateDTO userUpdateDTO, @MappingTarget User user);
    void createUserFromDTO(UserCreateDTO userCreateDTO, @MappingTarget User user);

    List<UserShowDTO> toUserShowDTOs(List<User> user);
    UserShowDTO toUserShowDTO(User user);

}
