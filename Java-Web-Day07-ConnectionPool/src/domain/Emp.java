package domain;

import java.util.Date;

public class Emp {
    private Integer id;
    private String employee_name;
    private Integer job_id;
    private Integer mgr;
    private Date join_date;
    private Double salary;
    private Double bonus;
    private Integer dept_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEname() {
        return employee_name;
    }

    public void setEname(String employee_name) {
        this.employee_name = employee_name;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getJoindate() {
        return join_date;
    }

    public void setJoindate(Date join_date) {
        this.join_date = join_date;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", employee_name='" + employee_name + '\'' +
                ", job_id=" + job_id +
                ", mgr=" + mgr +
                ", join_date=" + join_date +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", dept_id=" + dept_id +
                '}';
    }
}
