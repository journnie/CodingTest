from collections import *

def solution(info, edges):
    tree = [[] for _ in range(len(info))]

    for parent, child in edges:
        tree[parent].append(child)
    
    max_sheep = 0
    
    def dfs(sheep_cnt, wolf_cnt, visitable):
        nonlocal max_sheep
        max_sheep = max(max_sheep, sheep_cnt)
        
        for node in list(visitable):
            next_sheep = sheep_cnt + (1 - info[node])
            next_wolf = wolf_cnt + info[node]
            
            if next_sheep > next_wolf:
                new_visitable = visitable - {node}
                new_visitable.update(tree[node])
                
                dfs(next_sheep, next_wolf, new_visitable)
    
    dfs(1, 0, set(tree[0]))
        
    return max_sheep