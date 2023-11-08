package ru.bfu.java.courseapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bfu.java.courseapi.dto.CourseResponseDto;
import ru.bfu.java.courseapi.dto.CourseRequestDto;
import ru.bfu.java.courseapi.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@Tag(name = "Courses API")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Operation(summary = "Список всех курсов")
    @GetMapping
    public List<CourseResponseDto> getCourses() {
        return courseService.getCourses();
    }

    @Operation(summary = "Информация о курсе с данным id")
    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Long id) {
        Optional<CourseResponseDto> courseOptional = courseService.getCourseById(id);
        return courseOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Создание нового курса")
    @PostMapping
    public ResponseEntity<CourseResponseDto> createCourse(@RequestBody CourseRequestDto courseCreateRequest) {
        CourseResponseDto course = courseService.createCourse(courseCreateRequest);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление информации о курсе")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto courseUpdateRequest) {
        boolean courseUpdated = courseService.updateCourse(id, courseUpdateRequest);
        return new ResponseEntity<>(courseUpdated ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Удаление курса")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        boolean courseDeleted = courseService.deleteCourse(id);
        return new ResponseEntity<>(courseDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
