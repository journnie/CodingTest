def right_pairs(parentheses):
    if len(parentheses) % 2 != 0: return False

    stack = []
    pairs = {'}':'{', ')':'(', ']':'['}
    
    for p in parentheses:
        if p in '{([': 
            stack.append(p)
        else:
            if len(stack)== 0 : return False
            if not stack.pop() == pairs[p]: return False
    
    return len(stack)== 0 # not stack
    
    

def solution(s):
    answer = 0
    parentheses = s
        
    for i in range(len(s)):
        if right_pairs(parentheses): 
            answer += 1
            
        parentheses = parentheses[1:]+parentheses[0]
        
    return answer