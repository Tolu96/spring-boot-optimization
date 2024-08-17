package com.tolunayoezcan.spring_boot_optimization.mapper;


import com.tolunayoezcan.spring_boot_optimization.dto.LecturerDTO;
import com.tolunayoezcan.spring_boot_optimization.model.Lecturer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LecturerMapper {

    LecturerMapper INSTANCE = Mappers.getMapper(LecturerMapper.class);

    LecturerDTO modelToDto(Lecturer lecturer);

    List<LecturerDTO> modelsToDto(List<Lecturer> lecturer);

    Lecturer dtoToModel(LecturerDTO lecturerDTO);

}
