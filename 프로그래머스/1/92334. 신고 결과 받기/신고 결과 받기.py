from collections import *

def solution(id_list, report, k):
    answer = [0 for _ in range(len(id_list))]
    users = defaultdict(set)
    reported = defaultdict(set)
    
    for r in report:
        a, b = r.split()
        users[a].add(b)
        reported[b].add(a)
        
    for i, id in enumerate(id_list):
        for reported_id in users[id]:
            if len(reported[reported_id]) >= k:
                answer[i] += 1
    
    return answer