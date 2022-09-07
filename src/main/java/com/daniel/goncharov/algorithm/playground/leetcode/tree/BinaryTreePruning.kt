package com.daniel.goncharov.algorithm.playground.leetcode.tree

import com.daniel.goncharov.algorithm.playground.interviewbit.tree.TreeNode

class BinaryTreePruning {

    fun pruneTree(root: TreeNode?): TreeNode? {
        return if (shouldPrune(root)) {
            null
        } else {
            root
        }
    }

    private fun shouldPrune(root: TreeNode?): Boolean {
        root ?: return true
        if (root.isLeaf()) return root.`val` == 0

        val shouldPruneLeft = shouldPrune(root.left)
        val shouldPruneRight = shouldPrune(root.right)

        if (shouldPruneLeft) {
            root.left = null
        }

        if (shouldPruneRight) {
            root.right = null
        }
        return shouldPruneLeft && shouldPruneRight && root.`val` == 0
    }

    private fun TreeNode.isLeaf(): Boolean = this.left == null && this.right == null
}

