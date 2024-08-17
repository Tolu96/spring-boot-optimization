package com.tolunayoezcan.spring_boot_optimization.mapper;

import com.tolunayoezcan.spring_boot_optimization.dto.StudentDTO;
import com.tolunayoezcan.spring_boot_optimization.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = UUID.class)
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO modelToDto(Student student);

    List<StudentDTO> modelsToDto(List<Student> student);

    Student dtoToModel(StudentDTO studentDTO);


}
