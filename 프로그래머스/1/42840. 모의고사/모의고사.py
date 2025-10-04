def solution(answers):
    patterns = [[1, 2, 3, 4, 5,],
                [2, 1, 2, 3, 2, 4, 2, 5],
                [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    scores = [0 for _ in range(3)]
    answer = []
    
    for i, ans in enumerate(answers):
        for s in range(3):
            if(patterns[s][i%len(patterns[s])] == ans):
                scores[s]+=1
    
    for i, score in enumerate(scores):
        if(score == max(scores)): answer.append(i+1)
    
    return sorted(answer)