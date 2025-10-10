from itertools import *

def solution(users, emoticons):
    answer = [0, 0] # 플러스가입자수, 이모티콘판매액
    rate = [10, 20, 30, 40]
    
    for sale in product(rate, repeat = len(emoticons)):
        temp = [0, 0]   # 플러스가입자수, 이모티콘판매액
        for u, (buy_rate, limit) in enumerate(users):
            total = 0
            for i, r in enumerate(sale):
                if (r >= buy_rate) :
                    total += emoticons[i]*(1-r*0.01)
            if total >= limit:
                temp[0] += 1
            else: temp[1] += total
            
        answer = max(answer, temp)
    
    return answer