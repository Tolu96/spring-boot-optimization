package com.tolunayoezcan.spring_boot_optimization.mapper;

import com.tolunayoezcan.spring_boot_optimization.dto.DegreeProgramDTO;
import com.tolunayoezcan.spring_boot_optimization.model.DegreeProgram;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DegreeProgramMapper {

    DegreeProgramMapper INSTANCE = Mappers.getMapper(DegreeProgramMapper.class);

    DegreeProgramDTO modelToDto(DegreeProgram degreeProgram);

    List<DegreeProgramDTO> modelsToDto(List<DegreeProgram> degreePrograms);

    DegreeProgram dtoToModel(DegreeProgramDTO degreeProgramDTO);

}
