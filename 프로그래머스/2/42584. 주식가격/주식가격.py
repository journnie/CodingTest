def solution(prices):
    stockes = len(prices)
    answer = [0 for _ in range(stockes)]
    
    for s in range(stockes):
        for p in range(s+1, stockes):
            answer[s] +=1
            if prices[s] > prices[p]: break
        
    return answer