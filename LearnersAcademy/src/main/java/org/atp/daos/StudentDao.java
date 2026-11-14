package org.atp.daos;

import org.atp.entities.Student;



public interface StudentDao {
    void saveStudent(Student student);
    Student getStudent(int sid);

}
