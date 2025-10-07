from collections import *
def solution(want, number, discount):
    answer = 0
    
    wants = {}
    for i in range(len(want)):
        wants[want[i]] = number[i]
    
    for i in range(0, len(discount)-9):
        discounts = Counter(discount[i:i+10])
        
        if wants == discounts : answer += 1
    
    return answer