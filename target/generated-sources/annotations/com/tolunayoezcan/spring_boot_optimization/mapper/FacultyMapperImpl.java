package com.tolunayoezcan.spring_boot_optimization.mapper;

import com.tolunayoezcan.spring_boot_optimization.dto.FacultyDTO;
import com.tolunayoezcan.spring_boot_optimization.model.Faculty;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-16T15:38:21+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class FacultyMapperImpl implements FacultyMapper {

    @Override
    public FacultyDTO modelToDto(Faculty faculty) {
        if ( faculty == null ) {
            return null;
        }

        FacultyDTO facultyDTO = new FacultyDTO();

        facultyDTO.setFacultyId( faculty.getFacultyId() );
        facultyDTO.setName( faculty.getName() );
        facultyDTO.setAbbreviation( faculty.getAbbreviation() );

        return facultyDTO;
    }

    @Override
    public List<FacultyDTO> modelsToDto(List<Faculty> faculties) {
        if ( faculties == null ) {
            return null;
        }

        List<FacultyDTO> list = new ArrayList<FacultyDTO>( faculties.size() );
        for ( Faculty faculty : faculties ) {
            list.add( modelToDto( faculty ) );
        }

        return list;
    }

    @Override
    public Faculty dtoToModel(FacultyDTO facultyDTO) {
        if ( facultyDTO == null ) {
            return null;
        }

        Faculty faculty = new Faculty();

        faculty.setFacultyId( facultyDTO.getFacultyId() );
        faculty.setName( facultyDTO.getName() );
        faculty.setAbbreviation( facultyDTO.getAbbreviation() );

        return faculty;
    }
}
