package com.tolunayoezcan.spring_boot_optimization.mapper;


import com.tolunayoezcan.spring_boot_optimization.dto.FacultyDTO;
import com.tolunayoezcan.spring_boot_optimization.model.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FacultyMapper {

    FacultyMapper INSTANCE = Mappers.getMapper(FacultyMapper.class);

    FacultyDTO modelToDto(Faculty faculty);

    List<FacultyDTO> modelsToDto(List<Faculty> faculties);

    Faculty dtoToModel(FacultyDTO facultyDTO);

}
