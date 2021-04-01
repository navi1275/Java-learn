package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * NestedIntegerImpl Class
 *
 * @author ganxf
 * @date 2021/3/23
 */
public class NestedIntegerImpl implements NestedInteger {

    Integer val;
    NestedIntegerImpl next;

    public NestedIntegerImpl() {
    }

    public NestedIntegerImpl(int val) {
        this.val = val;
    }

    @Override
    public boolean isInteger() {
        return val == null || next == null;
    }

    @Override
    public Integer getInteger() {
        return val;
    }

    @Override
    public List<NestedInteger> getList() {
        List<NestedInteger> ret = new ArrayList<>();
        NestedIntegerImpl p = this;
        while (p != null){
            ret.add(p);
            NestedIntegerImpl q = p.next;
            p.next = null;
            p = q;
        }
        return ret;
    }
}
