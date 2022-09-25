package com.daniel.goncharov.algorithm.playground.leetcode.tree

import com.daniel.goncharov.algorithm.playground.interviewbit.tree.TreeNode

class SmallestSubtreeWithAllTheDeepestNodes {

    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
        val dequeue = ArrayDeque<Level>().apply {
            root?.let { node -> this.add(Level(0, node)) }
        }
        val parentMap = HashMap<TreeNode, TreeNode?>().apply { root?.let { put(it, null) } }
        val deepestLevel = arrayListOf<Level>()
        while (!dequeue.isEmpty()) {
            val currentElement = dequeue.removeFirst()
            when {
                currentElement.isLeaf() && deepestLevel.isEmpty() -> {
                    deepestLevel.add(currentElement)
                }
                currentElement.isLeaf() && currentElement.level > deepestLevel.first().level -> {
                    deepestLevel.clear()
                    deepestLevel.add(currentElement)
                }
                currentElement.isLeaf() && currentElement.level == deepestLevel.first().level ->
                    deepestLevel.add(currentElement)
                !currentElement.isLeaf() -> {
                    dequeue.addChildren(currentElement, parentMap)
                }
            }

        }

        var deepestLeaf = deepestLevel.map(Level::node)
        while (deepestLeaf.isNotEmpty()) {
            val set = hashSetOf<TreeNode>()
            for (leaf in deepestLeaf) {
                val parent = parentMap[leaf]
                parent?.let(set::add)
            }
            when {
                set.isEmpty() -> return root
                set.size == 1 -> return set.first()
                else -> deepestLeaf = set.toList()
            }
        }
        return root
    }

    private fun ArrayDeque<Level>.addChildren(level: Level, parentMap: HashMap<TreeNode, TreeNode?>) {
        addElement(level, level.node.left, parentMap)
        addElement(level, level.node.right, parentMap)
    }

    private fun ArrayDeque<Level>.addElement(level: Level, node: TreeNode?, parentMap: HashMap<TreeNode, TreeNode?>) {
        if (node != null) {
            parentMap[node] = level.node
            add(Level(level.node.`val` + 1, node))
        }
    }

    fun Level.isLeaf(): Boolean {
        return this.node.right == null && this.node.left == null
    }

    data class Level(
        val level: Int,
        val node: TreeNode
    )


}