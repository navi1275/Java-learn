package com.navi.beancopy.mapstruct;

import com.navi.beancopy.dto.Student;
import com.navi.beancopy.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * StudentConverter Class
 *
 * @author ganxf
 * @date 2020/8/14
 */
@Mapper
public interface StudentConverter {

    StudentConverter  converter = Mappers.getMapper(StudentConverter.class);

    @Mappings({
            @Mapping(source = "birthday", target = "birth"),
            @Mapping(source = "birthday", target = "birthDateFormat", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "birthExpressionFormat", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(person.getBirthday(),\"yyyy-MM-dd HH:mm:ss\"))"),
            @Mapping(source = "user.age", target = "age"),
            @Mapping(target = "email", ignore = true)
    })
    StudentDTO domain2dto(Student person);

    List<StudentDTO> domain2dto(List<Student> people);

}
