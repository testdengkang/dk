package com.web.model;

public class TPermission {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_PERMISSION.ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_PERMISSION.PERMISSION
     *
     * @mbggenerated
     */
    private String permission;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_PERMISSION.DESCRIPTION
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_PERMISSION.AVAILABLE
     *
     * @mbggenerated
     */
    private String available;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_PERMISSION.ID
     *
     * @return the value of T_PERMISSION.ID
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_PERMISSION.ID
     *
     * @param id the value for T_PERMISSION.ID
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_PERMISSION.PERMISSION
     *
     * @return the value of T_PERMISSION.PERMISSION
     *
     * @mbggenerated
     */
    public String getPermission() {
        return permission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_PERMISSION.PERMISSION
     *
     * @param permission the value for T_PERMISSION.PERMISSION
     *
     * @mbggenerated
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_PERMISSION.DESCRIPTION
     *
     * @return the value of T_PERMISSION.DESCRIPTION
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_PERMISSION.DESCRIPTION
     *
     * @param description the value for T_PERMISSION.DESCRIPTION
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_PERMISSION.AVAILABLE
     *
     * @return the value of T_PERMISSION.AVAILABLE
     *
     * @mbggenerated
     */
    public String getAvailable() {
        return available;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_PERMISSION.AVAILABLE
     *
     * @param available the value for T_PERMISSION.AVAILABLE
     *
     * @mbggenerated
     */
    public void setAvailable(String available) {
        this.available = available == null ? null : available.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", permission=").append(permission);
        sb.append(", description=").append(description);
        sb.append(", available=").append(available);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION
     *
     * @mbggenerated
     */
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
        TPermission other = (TPermission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPermission() == null ? other.getPermission() == null : this.getPermission().equals(other.getPermission()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getAvailable() == null ? other.getAvailable() == null : this.getAvailable().equals(other.getAvailable()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPermission() == null) ? 0 : getPermission().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getAvailable() == null) ? 0 : getAvailable().hashCode());
        return result;
    }
}