import java.util.Scanner;

public class HashTab {
    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable(7);

        // 菜单
        String key = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("(a) add  :  添加雇员");
            System.out.println("(l) list :  显示雇员");
            System.out.println("(f) find :  查询雇员");
            System.out.println("(d) del  :  删除雇员");
            System.out.println("(e) exit :  退出系统");

            int id = 0;

            key = sc.next();
            switch (key) {
                case "a" :
                    System.out.println("请输入id：");
                    id = sc.nextInt();
                    System.out.println("请输入姓名：");
                    String name = sc.next();
                    Emp emp = new Emp(id, name);
                    myHashTable.add(emp);
                    break;
                case "l" :
                    myHashTable.list();
                    break;
                case "f" :
                    System.out.println("请输入id：");
                    id = sc.nextInt();
                    myHashTable.findEmpById(id);
                    break;
                case "d" :
                    System.out.println("请输入id：");
                    id = sc.nextInt();
                    myHashTable.deleteEmpById(id);
                    break;    
                case "e" :
                    sc.close();
                    return;
            }
        }
    }

}

class MyHashTable {
    private EmpLinkedList[] empLinkedLists;
    private int size;

    public MyHashTable(int size) {
        this.size = size;
        this.empLinkedLists = new EmpLinkedList[size];

        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    // 添加雇员
    public void add(Emp emp) {
        int index = hashFun(emp.id);
        empLinkedLists[index].add(emp);
    }

    // 遍历链表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i + 1);
        }
    }

    // 查找雇员
    public Emp findEmpById(int id) {
        return empLinkedLists[hashFun(id)].findEmpById(id);
    }

    // 删除雇员
    public boolean deleteEmpById(int id) {
        if (empLinkedLists[hashFun(id)].deleteEmpById(id)) {
            System.out.println("删除成功！");
            return true;
        }

        System.out.println("删除失败，没有找到该雇员");
        return false;
    }

    // 散列函数
    public int hashFun(int id) {
        return id % size;
    }
}

// 表示一个职员
class Emp {
    public int id;
    public String name;
    public Emp next;
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// 职员链表
class EmpLinkedList {
    public Emp head;

    // 添加雇员
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }

        Emp cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = emp;
    }

    // 遍历雇员
    public void list(int index) {
        if (head == null) {
            System.out.println("第" + index + "条链表为空");
            return;
        }

        System.out.print("第" + index + "条链表信息为：");
        Emp cur = head;
        while (cur != null) {
            System.out.print(" id = " + cur.id + ", name = " + cur.name + " ==>");
            cur = cur.next;
        }

        System.out.println();
    }

    // 查找雇员
    public Emp findEmpById(int id) {
        Emp cur = head;

        while (cur != null) {
            if (cur.id == id) {
                System.out.println("找到了！雇员信息为： id = " + cur.id + " name = " + cur.name);
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    // 删除雇员
    public boolean deleteEmpById(int id) {
        if (head == null) {
            return false;
        }

        if (head.id == id) {
            if (head.next != null) {
                head = head.next;
                return true;
            }
            
            head = null;
            return true;
        }

        Emp cur = head;
        while (cur.next != null) {
            if (cur.next.id == id) {
                if (cur.next.next != null) {
                    cur.next = cur.next.next;
                }

                if (cur.next.next == null) {
                    cur.next = null;
                }

                return true;
            }
        }

        return false;
    }
}