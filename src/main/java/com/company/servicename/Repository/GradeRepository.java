package com.company.servicename.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.company.servicename.Constants;
import com.company.servicename.Grade;

// We can also use the annotations @Servive and @Repository 
// for converting a class to a spring bean
// These two are same as @Component and there is no differnce between them
// @Component

@Repository
public class GradeRepository {
    private List<Grade> studentGrades = new ArrayList<>(Arrays.asList(
            new Grade("Messi", "Barcelona", "100"),
            new Grade("Ronaldo", "Real Madrid", "100"),
            new Grade("Mo Salah", "Liverpool", "90")));

    

    public Grade getGrade(int index) {
        return studentGrades.get(index);
    }

    public void addGrade(Grade grade) {
        studentGrades.add(grade);
    }

    public void updateGrade(int index, Grade grade) {
        studentGrades.set(index, grade);
    }

    public List<Grade> getGrades() {
        return studentGrades;
    }
}
