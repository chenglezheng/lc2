package com.lc.clz.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "object_table", schema = "lc", catalog = "")
@IdClass(ObjectTablePK.class)
public class ObjectTable {
    private String logicalTableName;
    private String physicalTableName;
    private String tableComment;
    private Integer primarykeyCount;
    private String primarykeyName;
    private String schemaName;
    private String categoryName;
    private String className;
    private String displayColumn;
    private String displayColumnObject;
    private String displayColumnObjectColumn;

    @Id
    @Column(name = "logical_table_name", nullable = false, length = 50)
    public String getLogicalTableName() {
        return logicalTableName;
    }

    public void setLogicalTableName(String logicalTableName) {
        this.logicalTableName = logicalTableName;
    }

    @Id
    @Column(name = "physical_table_name", nullable = false, length = 50)
    public String getPhysicalTableName() {
        return physicalTableName;
    }

    public void setPhysicalTableName(String physicalTableName) {
        this.physicalTableName = physicalTableName;
    }

    @Basic
    @Column(name = "table_comment", nullable = true, length = 50)
    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    @Basic
    @Column(name = "primarykey_count", nullable = true)
    public Integer getPrimarykeyCount() {
        return primarykeyCount;
    }

    public void setPrimarykeyCount(Integer primarykeyCount) {
        this.primarykeyCount = primarykeyCount;
    }

    @Basic
    @Column(name = "primarykey_name", nullable = true, length = 50)
    public String getPrimarykeyName() {
        return primarykeyName;
    }

    public void setPrimarykeyName(String primarykeyName) {
        this.primarykeyName = primarykeyName;
    }

    @Basic
    @Column(name = "schema_name", nullable = true, length = 50)
    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    @Basic
    @Column(name = "category_name", nullable = true, length = 50)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "class_name", nullable = true, length = 100)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Basic
    @Column(name = "display_column", nullable = true, length = 50)
    public String getDisplayColumn() {
        return displayColumn;
    }

    public void setDisplayColumn(String displayColumn) {
        this.displayColumn = displayColumn;
    }

    @Basic
    @Column(name = "display_column_object", nullable = true, length = 50)
    public String getDisplayColumnObject() {
        return displayColumnObject;
    }

    public void setDisplayColumnObject(String displayColumnObject) {
        this.displayColumnObject = displayColumnObject;
    }

    @Basic
    @Column(name = "display_column_object_column", nullable = true, length = 50)
    public String getDisplayColumnObjectColumn() {
        return displayColumnObjectColumn;
    }

    public void setDisplayColumnObjectColumn(String displayColumnObjectColumn) {
        this.displayColumnObjectColumn = displayColumnObjectColumn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectTable that = (ObjectTable) o;
        return Objects.equals(logicalTableName, that.logicalTableName) &&
                Objects.equals(physicalTableName, that.physicalTableName) &&
                Objects.equals(tableComment, that.tableComment) &&
                Objects.equals(primarykeyCount, that.primarykeyCount) &&
                Objects.equals(primarykeyName, that.primarykeyName) &&
                Objects.equals(schemaName, that.schemaName) &&
                Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(className, that.className) &&
                Objects.equals(displayColumn, that.displayColumn) &&
                Objects.equals(displayColumnObject, that.displayColumnObject) &&
                Objects.equals(displayColumnObjectColumn, that.displayColumnObjectColumn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(logicalTableName, physicalTableName, tableComment, primarykeyCount, primarykeyName, schemaName, categoryName, className, displayColumn, displayColumnObject, displayColumnObjectColumn);
    }
}
