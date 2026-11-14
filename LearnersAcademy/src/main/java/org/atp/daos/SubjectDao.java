package org.atp.daos;

import org.atp.entities.Subject;

public interface SubjectDao {
    void saveSubject(Subject subject);
    Subject getSubject(int subid);
}
