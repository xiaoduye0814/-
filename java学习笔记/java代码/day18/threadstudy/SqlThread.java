package threadstudy;

public class SqlThread {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Sql sql = new Sql();
        DBA db = new DBA(sql);
        User user = new User(sql);
        new Thread(db).start();
        new Thread(user).start();
    }

}

class Sql {
    String name;
    String sex;

    // 更新与否
    boolean change = false;
}

class DBA implements Runnable {

    private Sql sql;

    public DBA(Sql sql) {
        this.sql = sql;
    }

    public void run() {
        int num = 0;
        while (true) {
            synchronized (sql) {
                if (sql.change) {
                    try {
                        sql.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (num == 0) {
                    sql.name = "zhangsan";
                    sql.sex = "male";
                } else {
                    sql.name = "xiaohong";
                    sql.sex = "female";
                }
                num = (num + 1) % 2;
                sql.change = true;
                sql.notify();
            }
        }

    }
}

class User implements Runnable {
    private Sql sql;

    public User(Sql sql) {
        this.sql = sql;
    }

    public void run() {
        while (true) {
            synchronized (sql) {
                if (!sql.change) {
                    try {
                        sql.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("姓名" + sql.name + "       ");
                System.out.println(" 性别：" + sql.sex);
                sql.change = false;
                sql.notify();
            }
        }
    }
}