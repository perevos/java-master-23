package ru.bfu.java.courseapi.mapper;

import ru.bfu.java.courseapi.dto.CourseResponseDto;
import ru.bfu.java.courseapi.dto.CourseRequestDto;
import ru.bfu.java.courseapi.entity.CourseEntity;

public final class CourseMapper {

    public static CourseResponseDto mapToDto(CourseEntity entity) {
        CourseResponseDto dto = new CourseResponseDto();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setNumberOfLectures(entity.getNumberOfLectures());

        return dto;
    }

    public static CourseEntity mapToEntity(CourseRequestDto requestDto) {
        CourseEntity entity = new CourseEntity();

        entity.setTitle(requestDto.getTitle());
        entity.setDescription(requestDto.getDescription());
        entity.setNumberOfLectures(requestDto.getNumberOfLectures());

        return entity;
    }

    public static CourseEntity mapToEntity(Long courseId, CourseRequestDto requestDto) {
        CourseEntity entity = mapToEntity(requestDto);

        entity.setId(courseId);

        return entity;
    }
}
