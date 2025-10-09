import sys
# 재귀 깊이 제한을 해제하여 런타임 오류 방지 (트리 깊이가 깊을 경우)
sys.setrecursionlimit(10**6) 


class Node:
    def __init__(self, x, y, id):
        self.x = x
        self.y = y
        self.id = id
        self.left = None
        self.right = None
    
def insert_node(root, new_node):
    if root is None:
        return new_node

    if new_node.x < root.x:
        root.left = insert_node(root.left, new_node)
    else:
        root.right = insert_node(root.right, new_node)
    return root

def solution(nodeinfo):
    
    nodes = []
    
    for i, (x, y) in enumerate(nodeinfo):
        nodes.append((x, y, i+1))
        
    nodes.sort(key=lambda item: (-item[1], item[0]))
    
    root = None
    for x, y, id in nodes:
        new_node = Node(x, y, id)
        if root is None:
            root = new_node
        else:
            insert_node(root, new_node)
            
    preorder_result = []
    postorder_result = []
    
    def preorder(node):
        if node is None: return
        preorder_result.append(node.id)
        preorder(node.left)
        preorder(node.right)
        
    def postorder(node):
        if node is None: return
        postorder(node.left)
        postorder(node.right)
        postorder_result.append(node.id)
        
    if root:
        preorder(root)
        postorder(root)
    
    
    return [preorder_result, postorder_result]