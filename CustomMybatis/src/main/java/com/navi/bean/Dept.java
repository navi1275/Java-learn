package com.navi.bean;

/**
 * Dept Class
 *
 * @author ganxf
 * @date 2018/11/12
 */
public class Dept {

    private Integer deptNo;

    private String dname;

    private String loc;

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"deptNo\":")
                .append(deptNo);
        sb.append(",\"dname\":\"")
                .append(dname).append('\"');
        sb.append(",\"loc\":\"")
                .append(loc).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
