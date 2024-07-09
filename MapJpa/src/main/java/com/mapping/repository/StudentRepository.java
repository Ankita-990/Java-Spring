package com.mapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mapping.bean.Bean;
import com.mapping.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> 
{
	@Query(value = " select s.id AS studentId, s.student_name AS studentName, s.percentage AS percentage, addr.city AS city, addr.country AS country, "
			+ " lap.laptop_model AS model, lap.price AS price, c.course_name AS courseName "
			+ " from student s "
			+ " LEFT JOIN address addr on addr.student_id = s.id "
			+ " LEFT JOIN laptop lap on lap.student_id = s.id "
			+ " LEFT JOIN course_students sc ON s.id = sc.students_id "
			+ " LEFT JOIN Course c ON sc.courses_id = c.id ", 
			nativeQuery = true)
	List<Bean> getJoinTable();
	
	@Query(value = " select s.id AS studentId, s.student_name AS studentName, s.percentage AS percentage, addr.city AS city, addr.country AS country, "
			+ " lap.laptop_model AS model, lap.price AS price, c.course_name AS courseName "
			+ " from student s "
			+ " LEFT JOIN address addr on addr.student_id = s.id "
			+ " LEFT JOIN laptop lap on lap.student_id = s.id "
			+ " LEFT JOIN course_students sc ON s.id = sc.students_id "
			+ " LEFT JOIN Course c ON sc.courses_id = c.id "
			+ " where s.id=? ", 
			nativeQuery = true)
	List<Bean> getJoinTableById(Integer studentId);
}
