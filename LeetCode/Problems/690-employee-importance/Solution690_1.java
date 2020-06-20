/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

/*
哈希表存每个员工的重要度

递归
终止条件 subordinates size =0
*/


class Solution {
    Map<Integer, List<Integer>> subMap; // id对应下属
    Map<Integer, Integer> imMap; // id对应分数

    public int getImportance(List<Employee> employees, int id) {
        subMap = new HashMap<>();
        imMap = new HashMap<>();

        for (int i = 0; i < employees.size(); i++) {
            subMap.put(employees.get(i).id, employees.get(i).subordinates);
            imMap.put(employees.get(i).id, employees.get(i).importance);
        }

        return recur(id);
    }

    private int recur(int id) {
        if (subMap.get(id).size() == 0) return imMap.get(id);
        int count = imMap.get(id);
        for (int i = 0; i < subMap.get(id).size(); i++) {
            count += recur(subMap.get(id).get(i));
        }
        return count;
    }

}