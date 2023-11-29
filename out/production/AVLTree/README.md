# AVLTree
This is a Java implementation of an AVL tree data stucture that stores nodes that contain integer values. 

The AVL tree is a self-balancing binary search tree. As such, it adheres to the same rules as a normal binary search tree, where nodes in the left subtree are less than the root and nodes in the right subtree are greater than the root. Ideally, this results in a data structure that allows for insert, find, and delete operations to be performed in O(log n) time. However, the structure of the binary search tree is dependent on the order of the inserted data. Suppose a set of data is inserted into the binary search tree in increasing order. The resulting data structure would be a series of singly linked nodes, effectively becoming a singly linked list with the same find, insert, and delete operations performing in O(n) time. 

The advantage of an AVL tree comes from its ability to prevent this event from ever occuring, ensuring that the insert, find, and delete operations are always performed in O(log n) time. To accomplish this, each node in the tree is assigned a balance factor value, ranging between -1 and +1. This value is determined by the following formula: 

    height of left subtree - height of right subtree = balance factor

Inserting a node into the tree may cause a previously inserted node to have a balance factor outside of the -1 to +1 range. If this occurs, the tree will restructure the subtree(s) of the unbalanced node, so that the unbalanced node and each node in the restructured subtree(s) has a balance factor between -1 and +1.

The self-balancing process of the AVL tree is dependent on where the last inserted node is located. In the event of an inserted node causing another node to become unbalanced, if the new node is inserted into the left subtree of the left child of the unbalanced node, the self-balancing operation performed is a single right rotation (R) on the unbalanced node. If the new node is inserted into the right subtree of the left child of the unbalanced node, a double right-left rotation (RL) is performed. If the new node is inserted into the right subtree of the right child of the unbalanced node, the self-balancing operation is a single left rotation (L), which is a mirror of the R operation. If the new node is inserted into the left subtree of the right child of the unbalanced node, the operation performed is a double left-right rotation (LR), mirroring the RL rotation. Through these rotations, the AVL tree is able to maintain a balanced structure that allows for more efficient operations. More detailed explanations of each type of rotation are given below.

Right rotation (R)
-------------------
        3                       2
       /         R(3)          / \
      2          ---->        1   3
     /
    1

1) The left child of the root node (2) becomes the new root. 

2) The previous root (3) sets its left child pointer as null and becomes the right child of the new root. 

Left rotation (L)
------------------
    1                           2
     \           L(1)          / \
      2          ---->        1   3
       \
        3

1) The right child of the root (2) becomes the new root.

2) The previous root (1) sets its right child pointer to null and becomes the left child of the new root. 

Double right-left rotation (RL)
------------------------
        3                       3                    2
       /         L(1)          /        R(3)        / \
      1          ---->        2         ---->      1   3
       \                     /
        2                   1

1) A left rotation is performed on the left child of the root node (1).

2) A right rotation is performed on the root node (3). 

Double left-right rotation (LR)
------------------------
        1                   1                        2
         \       R(3)        \          L(1)        / \
          3      ---->        2         ---->      1   3
         /                     \
        2                       3

1) A right rotation is performed on the right child of the root node (3).

2) A left rotation is performed on the root node (1). 
