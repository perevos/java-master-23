package ru.bfu.java.courseapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bfu.java.courseapi.dto.CourseResponseDto;
import ru.bfu.java.courseapi.dto.CourseRequestDto;
import ru.bfu.java.courseapi.entity.CourseEntity;
import ru.bfu.java.courseapi.mapper.CourseMapper;
import ru.bfu.java.courseapi.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseResponseDto> getCourses() {
        List<CourseEntity> courseEntities = courseRepository.findAll();
        return courseEntities.stream()
                .map(CourseMapper::mapToDto)
                .toList();
    }
    public Optional<CourseResponseDto> getCourseById(Long id) {
        Optional<CourseEntity> courseEntityOptional = courseRepository.findById(id);
        return courseEntityOptional.map(CourseMapper::mapToDto);
    }
    public CourseResponseDto createCourse(CourseRequestDto courseCreateRequest) {
        CourseEntity courseEntity = CourseMapper.mapToEntity(courseCreateRequest);
        CourseEntity savedCourseEntity = courseRepository.save(courseEntity);
        return CourseMapper.mapToDto(savedCourseEntity);
    }
    public boolean updateCourse(Long id, CourseRequestDto courseUpdateRequest) {
        if (!courseRepository.existsById(id)) {
            return false;
        }
        CourseEntity courseEntity = CourseMapper.mapToEntity(id, courseUpdateRequest);
        courseRepository.save(courseEntity);
        return true;
    }
    public boolean deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            return false;
        }
        courseRepository.deleteById(id);
        return true;
    }
}
