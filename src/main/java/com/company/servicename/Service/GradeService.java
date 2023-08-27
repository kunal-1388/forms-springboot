package com.company.servicename.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.company.servicename.Constants;
import com.company.servicename.Grade;
import com.company.servicename.Repository.GradeRepository;


// We can also use the annotations @Servive and @Repository 
// for converting a class to a spring bean
// These two are same as @Component and there is no differnce between them
// @Component
@Service
public class GradeService {

    @Autowired
    GradeRepository gradeRepository;

    public Grade getGrade(int index) {
        return gradeRepository.getGrade(index);
    }

    public void addGrade(Grade grade) {
        gradeRepository.addGrade(grade);
    }

    public void updateGrade(int index, Grade grade) {
        gradeRepository.updateGrade(index, grade);
    }

    public List<Grade> getGrades() {
        return gradeRepository.getGrades();
    }

    public Integer findIndex(String id) {
        if (id == null) {
            return Constants.NOT_FOUND;
        }
        for (int i = 0; i < gradeRepository.getGrades().size(); i++) {
            if (gradeRepository.getGrades().get(i).getId().equals(id) == true) {
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }

    public Grade getGradeById(String id) {
        int index = findIndex(id);
        return index == Constants.NOT_FOUND ? new Grade() : gradeRepository.getGrade(index);
    }

    public void submitGrade(Grade grade) {
        Integer index = findIndex(grade.getId());

        if (index == Constants.NOT_FOUND) {
            gradeRepository.addGrade(grade);
        } else {
            gradeRepository.updateGrade(index, grade);
        }
    }

}
