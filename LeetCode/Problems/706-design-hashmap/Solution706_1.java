/**
 * 不使用任何内建的哈希表库设计一个哈希映射
 * <p>
 * 具体地说，你的设计应该包含以下的功能
 * <p>
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 * <p>
 * 示例：
 * <p>
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);        
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 * <p>
 * 注意：
 * <p>
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution706_1 {

    class MyHashMap {
        private int size = 1000; // 默认数组大小
        private HashLinkedList[] hashLinkedLists;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            this.hashLinkedLists = new HashLinkedList[size];
            for (int i = 0; i < size; i++) {
                hashLinkedLists[i] = new HashLinkedList();
            }
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            hashLinkedLists[hash(key)].put(key, value);
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            return hashLinkedLists[hash(key)].get(key);
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            hashLinkedLists[hash(key)].remove(key);
        }

        public int hash(int key) {
            return key % size;
        }
    }

    // Map节点
    class MapNode {
        public int key;
        public int value;
        public MapNode next = null;

        public MapNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 自定义链表
    class HashLinkedList {
        public MapNode head; // 初始化为null

        // 放入map，需要判断是否已经有key，有的话直接更新
        public void put(int key, int value) {
            if (head == null) {
                head = new MapNode(key, value);
                return;
            }

            if (update(key, value)) {
                return;
            }

            MapNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }

            cur.next = new MapNode(key, value);
        }

        // 获取
        public int get(int key) {
            if (head == null) {
                return -1;
            }

            if (head.key == key) {
                return head.value;
            }

            MapNode cur = head;
            while (cur != null) {
                if (cur.key == key) {
                    return cur.value;
                }
                cur = cur.next;
            }

            return -1;
        }

        // 更新，结合put使用，单独使用的话需要判断head是否为空
        public boolean update(int key, int value) {
            // 单独使用put，判断是否为空
            // if (head == null) {
            //     head = new MapNode(key, value);
            //     return;
            // }

            if (head.key == key) {
                head.value = value;
                return true;
            }

            MapNode cur = head;
            while (cur != null) {
                if (cur.key == key) {
                    cur.value = value;
                    return true;
                }
                cur = cur.next;
            }

            return false;
        }

        // 移除
        public void remove(int key) {
            if (head == null) {
                return;
            }

            if (head.key == key) {
                if (head.next != null) {
                    head = head.next;
                    return;
                }

                head = null;
                return;
            }

            MapNode cur = head;
            while (cur.next != null) {
                if (cur.next.key == key) {
                    if (cur.next.next != null) {
                        cur.next = cur.next.next;
                    } else {
                        cur.next = null;
                    }

                    return;
                }

                cur = cur.next;
            }
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}