package leetcode.editor.cn;
 
//给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。 
//
// 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。 
//
// 
//
// 示例 1: 
//
// 输入: [[1,1],2,[1,1]]
//输出: [1,1,2,1,1]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 
//
// 示例 2: 
//
// 输入: [1,[4,[6]]]
//输出: [1,4,6]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
// 
// Related Topics 栈 设计 
// 👍 221 👎 0

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * LC341扁平化嵌套列表迭代器
 * 2021-03-23 09:08:18
 */
public class LC341扁平化嵌套列表迭代器{
    public static void main(String[] args) {
         // Solution solution = new LC341扁平化嵌套列表迭代器().new Solution();
         List<NestedInteger> nestedList = new ArrayList<>();
        NestedIntegerImpl nestedInteger1 = new NestedIntegerImpl(1);
        NestedIntegerImpl nestedInteger2 = new NestedIntegerImpl(1);
        NestedIntegerImpl nestedInteger3 = new NestedIntegerImpl(2);
        nestedInteger1.next = nestedInteger2;
        NestedIntegerImpl nestedInteger4 = new NestedIntegerImpl(1);
        NestedIntegerImpl nestedInteger5 = new NestedIntegerImpl(1);
        NestedIntegerImpl nestedInteger6 = new NestedIntegerImpl();
        nestedInteger4.next = nestedInteger5;
        // nestedList.add(nestedInteger1);
        // nestedList.add(nestedInteger3);
        // nestedList.add(nestedInteger4);
        nestedList.add(nestedInteger6);
        NestedIterator i = new LC341扁平化嵌套列表迭代器().new NestedIterator(nestedList);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    LinkedList<Integer> data = new LinkedList<>();
    NestedInteger nextNested = null;
    public NestedIterator(List<NestedInteger> nestedList) {
        paresList(nestedList);
    }

    private void paresList(List<NestedInteger> nestedList){
        if(nestedList != null && !nestedList.isEmpty()) {
            for (NestedInteger nestedInteger: nestedList) {
                if(nestedInteger.isInteger()){
                    data.add(nestedInteger.getInteger());
                }else{
                    paresList(nestedInteger.getList());
                }
            }
        }
    }

    @Override
    public Integer next() {
        return this.data.pop();
    }

    @Override
    public boolean hasNext() {
        return  !this.data.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)

}