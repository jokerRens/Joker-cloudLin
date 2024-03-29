package com.joker.bean.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName class_info
 */
@TableName(value ="class_info")
public class ClassInfo implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 名称
     */
    @TableField(value = "class_name")
    private String className;

    /**
     * 描述
     */
    @TableField(value = "class_desc")
    private String classDesc;

    /**
     * 隶属的学校
     */
    @TableField(value = "school_id")
    private Integer schoolId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 名称
     */
    public String getClassName() {
        return className;
    }

    /**
     * 名称
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 描述
     */
    public String getClassDesc() {
        return classDesc;
    }

    /**
     * 描述
     */
    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    /**
     * 隶属的学校
     */
    public Integer getSchoolId() {
        return schoolId;
    }

    /**
     * 隶属的学校
     */
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ClassInfo other = (ClassInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClassName() == null ? other.getClassName() == null : this.getClassName().equals(other.getClassName()))
            && (this.getClassDesc() == null ? other.getClassDesc() == null : this.getClassDesc().equals(other.getClassDesc()))
            && (this.getSchoolId() == null ? other.getSchoolId() == null : this.getSchoolId().equals(other.getSchoolId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClassName() == null) ? 0 : getClassName().hashCode());
        result = prime * result + ((getClassDesc() == null) ? 0 : getClassDesc().hashCode());
        result = prime * result + ((getSchoolId() == null) ? 0 : getSchoolId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", className=").append(className);
        sb.append(", classDesc=").append(classDesc);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}