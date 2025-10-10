max_diff, answer = 0, [-1]

def dfs(i, arrows, info, ryan):
    global max_diff, answer
    
    # 종료조건
    if i == 11 or arrows == 0:
        ryan[10] += arrows    # 남은 화살 처리
        diff = 0              # 차이 초기화
        for j in range(11):
            if info[j] or ryan[j]:
		            # 라이언이 많으면 더하고, 어피치가 많으면 빼기
                diff += (10 - j) * (1 if ryan[j] > info[j] else -1)
	       # 최대차이 갱신
	       # 가장 낮은 점수를 맞힌 개수가 같을 경우 
	       #계속해서 그다음으로 낮은 점수를 더 많이 맞힌 경우를 return
        if diff > 0 and diff >= max_diff:
            if diff > max_diff or ryan[::-1] > answer[::-1]:
                max_diff, answer = diff, ryan[:]
        ryan[10] -= arrows
        return
        
    # 점수를 획득하려면 어피치보다 한발이라도 더 많이 쏴야함    
    need = info[i] + 1
    if need <= arrows:  # 쏠 수 있음
        ryan[i] = need  # 해당 과녁에 쏜 화살 업뎃
        dfs(i + 1, arrows - need, info, ryan) # 다음 과녁 맞히기
        ryan[i] = 0    # 백트래킹 초기화
    dfs(i + 1, arrows, info, ryan) # 이번에 화살 안쐈다고 하고 다음 과녁

def solution(n, info):
    global max_diff, answer
    dfs(0, n, info, [0]*11)
    return answer
