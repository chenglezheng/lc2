package com.lc.clz.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "column_table", schema = "lc", catalog = "")
@IdClass(ColumnTablePK.class)
public class ColumnTable {
    private String logicalTableName;
    private String physicalTableName;
    private String columnName;
    private Integer columnSort;
    private String columnComment;
    private String refObject;
    private String refSearchObject;
    private String refDisplayObject;
    private String menuName;
    private String columnValue;
    private Integer isNotNull;
    private Integer isOpen;
    private Integer isEditor;
    private Integer isVisible;
    private Integer columnWith;
    private Integer columnDislplayType;
    private String validMethod;
    private Integer displayForm;
    private Integer isForzenColumn;

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
    @Column(name = "column_name", nullable = true, length = 50)
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @Basic
    @Column(name = "column_sort", nullable = true)
    public Integer getColumnSort() {
        return columnSort;
    }

    public void setColumnSort(Integer columnSort) {
        this.columnSort = columnSort;
    }

    @Basic
    @Column(name = "column_comment", nullable = true, length = 50)
    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    @Basic
    @Column(name = "ref_object", nullable = true, length = 50)
    public String getRefObject() {
        return refObject;
    }

    public void setRefObject(String refObject) {
        this.refObject = refObject;
    }

    @Basic
    @Column(name = "ref_search_object", nullable = true, length = 50)
    public String getRefSearchObject() {
        return refSearchObject;
    }

    public void setRefSearchObject(String refSearchObject) {
        this.refSearchObject = refSearchObject;
    }

    @Basic
    @Column(name = "ref_display_object", nullable = true, length = 50)
    public String getRefDisplayObject() {
        return refDisplayObject;
    }

    public void setRefDisplayObject(String refDisplayObject) {
        this.refDisplayObject = refDisplayObject;
    }

    @Basic
    @Column(name = "menu_name", nullable = true, length = 50)
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "column_value", nullable = true, length = 200)
    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }

    @Basic
    @Column(name = "is_not_null", nullable = true)
    public Integer getIsNotNull() {
        return isNotNull;
    }

    public void setIsNotNull(Integer isNotNull) {
        this.isNotNull = isNotNull;
    }

    @Basic
    @Column(name = "is_open", nullable = true)
    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    @Basic
    @Column(name = "is_editor", nullable = true)
    public Integer getIsEditor() {
        return isEditor;
    }

    public void setIsEditor(Integer isEditor) {
        this.isEditor = isEditor;
    }

    @Basic
    @Column(name = "is_visible", nullable = true)
    public Integer getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Integer isVisible) {
        this.isVisible = isVisible;
    }

    @Basic
    @Column(name = "column_with", nullable = true)
    public Integer getColumnWith() {
        return columnWith;
    }

    public void setColumnWith(Integer columnWith) {
        this.columnWith = columnWith;
    }

    @Basic
    @Column(name = "column_dislplay_type", nullable = true)
    public Integer getColumnDislplayType() {
        return columnDislplayType;
    }

    public void setColumnDislplayType(Integer columnDislplayType) {
        this.columnDislplayType = columnDislplayType;
    }

    @Basic
    @Column(name = "valid_method", nullable = true, length = 100)
    public String getValidMethod() {
        return validMethod;
    }

    public void setValidMethod(String validMethod) {
        this.validMethod = validMethod;
    }

    @Basic
    @Column(name = "display_form", nullable = true)
    public Integer getDisplayForm() {
        return displayForm;
    }

    public void setDisplayForm(Integer displayForm) {
        this.displayForm = displayForm;
    }

    @Basic
    @Column(name = "is_forzen_column", nullable = true)
    public Integer getIsForzenColumn() {
        return isForzenColumn;
    }

    public void setIsForzenColumn(Integer isForzenColumn) {
        this.isForzenColumn = isForzenColumn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnTable that = (ColumnTable) o;
        return Objects.equals(logicalTableName, that.logicalTableName) &&
                Objects.equals(physicalTableName, that.physicalTableName) &&
                Objects.equals(columnName, that.columnName) &&
                Objects.equals(columnSort, that.columnSort) &&
                Objects.equals(columnComment, that.columnComment) &&
                Objects.equals(refObject, that.refObject) &&
                Objects.equals(refSearchObject, that.refSearchObject) &&
                Objects.equals(refDisplayObject, that.refDisplayObject) &&
                Objects.equals(menuName, that.menuName) &&
                Objects.equals(columnValue, that.columnValue) &&
                Objects.equals(isNotNull, that.isNotNull) &&
                Objects.equals(isOpen, that.isOpen) &&
                Objects.equals(isEditor, that.isEditor) &&
                Objects.equals(isVisible, that.isVisible) &&
                Objects.equals(columnWith, that.columnWith) &&
                Objects.equals(columnDislplayType, that.columnDislplayType) &&
                Objects.equals(validMethod, that.validMethod) &&
                Objects.equals(displayForm, that.displayForm) &&
                Objects.equals(isForzenColumn, that.isForzenColumn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(logicalTableName, physicalTableName, columnName, columnSort, columnComment, refObject, refSearchObject, refDisplayObject, menuName, columnValue, isNotNull, isOpen, isEditor, isVisible, columnWith, columnDislplayType, validMethod, displayForm, isForzenColumn);
    }
}
