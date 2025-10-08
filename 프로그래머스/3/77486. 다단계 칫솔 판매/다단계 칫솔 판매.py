from collections import *

def solution(enroll, referral, seller, amount):
    answer = []
    parent = dict(zip(enroll, referral))
    total_money = defaultdict(int)
    
    for i, s in enumerate(seller):
        money = amount[i]*100
        cur_name = s
        
        while cur_name != "-" and money > 0:
            total_money[cur_name] += money - money//10
            cur_name = parent[cur_name]
            money //= 10
            
    return [total_money[name] for name in enroll]