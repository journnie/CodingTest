def solution(arr1, arr2):    
    r1, c1 = len(arr1), len(arr1[0])    
    r2, c2 = len(arr2), len(arr2[0])
    
    answer = [[0]*c2 for _ in range(r1)]
    
    for x in range(r1):
        for z in range(c2):
            for y in range(c1):
                answer[x][z] += arr1[x][y] * arr2[y][z] 


    return answer