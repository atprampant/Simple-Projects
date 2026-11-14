package org.atp.daos;

import org.atp.entities.EClass;

public interface EClassDao {
    void saveClass(EClass eclass);
    EClass getClass(int cid);
}
