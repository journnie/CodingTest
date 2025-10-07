def solution(participant, completion):
    answer = ''
    par = {}
    com = {}
    
    for p in participant:
        if p in par:
            par[p] += 1
        else:
            par[p] = 1
    
    for c in completion:
        par[c] -= 1
        
    for p in par:
        if par[p] != 0:
            answer = p
    
    return answer