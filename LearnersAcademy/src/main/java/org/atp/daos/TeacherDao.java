package org.atp.daos;

import org.atp.entities.Teacher;

public interface TeacherDao {
    void saveTeacher(Teacher teacher);
    Teacher getTeacher(int tid);
}
