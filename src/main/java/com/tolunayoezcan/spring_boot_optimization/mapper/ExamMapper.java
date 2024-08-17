package com.tolunayoezcan.spring_boot_optimization.mapper;

import com.tolunayoezcan.spring_boot_optimization.dto.ExamDTO;
import com.tolunayoezcan.spring_boot_optimization.model.Exam;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = UUID.class)
public interface ExamMapper {

    ExamMapper INSTANCE = Mappers.getMapper(ExamMapper.class);

    ExamDTO modelToDto(Exam exam);

    List<ExamDTO> modelsToDto(List<Exam> exams);

    Exam dtoToModel(ExamDTO examDTO);

}
