package cn.zcclj.springcloud.entity;

import java.io.Serializable;

/**
 * 〈〉
 *
 * @author 22902
 * @create 2019/1/7
 */
/*@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true) //链式*/
public class Dept implements Serializable {

    private Long deptno;

    private String dname;

    private String dbSource;

    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    public Dept() {
    }

    public Dept(Long deptno, String dname, String dbSource) {
        this.deptno = deptno;
        this.dname = dname;
        this.dbSource = dbSource;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", dbSource='" + dbSource + '\'' +
                '}';
    }
}
