# BST-java-project
The class "Binary Search Tree" (BST) can be implemented using an array of size N, where N represents the number of elements in the tree. Each row of the array represents a node of the tree and contains the fields info, left, and right of that node. The class supports the following operations:  

-Insertion of a random key: Inserts a new key into the binary search tree. The insertion algorithm places the new key in the appropriate position of the tree to maintain the property of the binary search tree.  
-Search for a random key: Searches for a key in the binary search tree. The search algorithm starts from the root of the tree and compares the key being searched with the key of the current node. If the keys are equal, the element is found. If the key is smaller, the search continues in the left subtree, and if it is larger, the search continues in the right subtree.    
-Inorder Traversal: Prints the keys of the binary search tree in ascending order. Inorder traversal is done recursively, starting from the left subtree, then the root, and finally the right subtree.  
The implementation is similar to the linked list implementation using an array. The "left" field has a value that indicates the position of the left subtree. The "right" field has a dual role:   
(a) it indicates the position of the right subtree and     
(b) is also used to implement the stack with the available positions of the array.  
If a node is deleted, it will be added to the top of the stack (and the AVAIL position will take the value of the deleted node's position). Therefore, to use methods for inserting and deleting elements from the BST, you will first need to implement the methods "getnode(tree_pointer)" and "free_node(tree_pointer)" in the stack of free positions in the array.  
In summary, the "Binary Search Tree" class is implemented using an array, where the "left" field indicates the position of the left subtree, and the "right" field serves both as the position of the right subtree and as the stack for available positions in the array. This implementation allows for efficient insertion and deletion of nodes in the binary search tree.  
