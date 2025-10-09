from collections import *
def solution(gems):
    n = len(gems)
    kinds = len(set(gems))
    dic = defaultdict(int)
    answer = [0, n-1]
    l = 0
    
    for r in range(n):
        dic[gems[r]] += 1
        
        while len(dic) == kinds:
            if r - l < answer[1] - answer[0]:
                answer = [l, r]
            dic[gems[l]] -= 1
            if dic[gems[l]] == 0: del dic[gems[l]]
            l += 1
    
    return [answer[0] + 1, answer[1] + 1]