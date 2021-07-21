package com.daniel.goncharov.algorithm.playground.tree;

import java.math.BigInteger;
import java.util.ArrayList;

public class SumRootToLeafNumbers {

    private final BigInteger MOD_VALUE = new BigInteger("1003");

    public int sumNumbers(TreeNode root) {
        ArrayList<BigInteger> result = new ArrayList<>();
        result.add(BigInteger.ZERO);
        findSum("", root, result);
        return result.get(0).intValue();
    }


    private void findSum(String currentNumber, TreeNode node, ArrayList<BigInteger> result) {
        if (node == null) return;
        String thisNumber = currentNumber + node.val;
        if (node.right == null && node.left == null) {
            BigInteger resultInt = new BigInteger(thisNumber)
                    .mod(MOD_VALUE)
                    .add(result.get(0))
                    .mod(MOD_VALUE);
            result.set(0, resultInt);
        } else {
            findSum(thisNumber, node.left, result);
            findSum(thisNumber, node.right, result);
        }

    }
}
