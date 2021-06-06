package io.kimmking.spring02;

import io.kimmking.spring01.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class Klass { 

    @Autowired
    List<Student> students;
    
    public void dong(){
        System.out.println(this.getStudents());
    }
    
}
