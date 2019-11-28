package com.lc.clz.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ObjectTablePK implements Serializable {
    private String logicalTableName;
    private String physicalTableName;

    @Column(name = "logical_table_name", nullable = false, length = 50)
    @Id
    public String getLogicalTableName() {
        return logicalTableName;
    }

    public void setLogicalTableName(String logicalTableName) {
        this.logicalTableName = logicalTableName;
    }

    @Column(name = "physical_table_name", nullable = false, length = 50)
    @Id
    public String getPhysicalTableName() {
        return physicalTableName;
    }

    public void setPhysicalTableName(String physicalTableName) {
        this.physicalTableName = physicalTableName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectTablePK that = (ObjectTablePK) o;
        return Objects.equals(logicalTableName, that.logicalTableName) &&
                Objects.equals(physicalTableName, that.physicalTableName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(logicalTableName, physicalTableName);
    }
}
