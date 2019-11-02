package cn.geliang.dsa.segmentTree;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019-11-02
 * @Created by Geliang TIAN
 */
public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,8};
        SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(arr, (e1, e2) -> e1 + e2);
        //System.out.println(segmentTree);
        System.out.println(segmentTree.query(0, 2));
    }
}
