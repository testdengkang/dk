package com.web.model;

public class TUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_USER.ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_USER.USERNAME
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_USER.PASSWORD
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_USER.SALT
     *
     * @mbggenerated
     */
    private String salt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_USER.LOCKED
     *
     * @mbggenerated
     */
    private String locked;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_USER.ID
     *
     * @return the value of T_USER.ID
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_USER.ID
     *
     * @param id the value for T_USER.ID
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_USER.USERNAME
     *
     * @return the value of T_USER.USERNAME
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_USER.USERNAME
     *
     * @param username the value for T_USER.USERNAME
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_USER.PASSWORD
     *
     * @return the value of T_USER.PASSWORD
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_USER.PASSWORD
     *
     * @param password the value for T_USER.PASSWORD
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_USER.SALT
     *
     * @return the value of T_USER.SALT
     *
     * @mbggenerated
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_USER.SALT
     *
     * @param salt the value for T_USER.SALT
     *
     * @mbggenerated
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_USER.LOCKED
     *
     * @return the value of T_USER.LOCKED
     *
     * @mbggenerated
     */
    public String getLocked() {
        return locked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_USER.LOCKED
     *
     * @param locked the value for T_USER.LOCKED
     *
     * @mbggenerated
     */
    public void setLocked(String locked) {
        this.locked = locked == null ? null : locked.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER
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
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", locked=").append(locked);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER
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
        TUser other = (TUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getLocked() == null ? other.getLocked() == null : this.getLocked().equals(other.getLocked()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getLocked() == null) ? 0 : getLocked().hashCode());
        return result;
    }
}