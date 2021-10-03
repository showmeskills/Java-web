package domain;

import java.util.Date;
import java.util.Objects;

public class Emp {
    private int id;
    private String employee_name;
    private int job_id;
    private int mgr;
    private Date join_date;
    private int salary;
    private double bonus;
    private int dept_id;

    public Emp() {
    }

    public Emp(int id, String employee_name, int job_id, int mgr, Date join_date, int salary, double bonus, int dept_id) {
        this.id = id;
        this.employee_name = employee_name;
        this.job_id = job_id;
        this.mgr = mgr;
        this.join_date = join_date;
        this.salary = salary;
        this.bonus = bonus;
        this.dept_id = dept_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getJobs_int() {
        return job_id;
    }

    public void setJobs_int(int jobs_int) {
        this.job_id = jobs_int;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return id == emp.id && job_id == emp.job_id && mgr == emp.mgr && salary == emp.salary && bonus == emp.bonus && dept_id == emp.dept_id && Objects.equals(employee_name, emp.employee_name) && Objects.equals(join_date, emp.join_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee_name, job_id, mgr, join_date, salary, bonus, dept_id);
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", employee_name='" + employee_name + '\'' +
                ", jobs_int=" + job_id +
                ", mgr=" + mgr +
                ", join_date=" + join_date +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", dept_id=" + dept_id +
                '}';
    }
}
