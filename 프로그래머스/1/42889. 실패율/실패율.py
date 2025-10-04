def solution(N, stages):
    stay = [0 for _ in range(N+2)]
    # 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
    # stages[player]==stage / stages[player]>=stage
    
    for stage in stages:
        stay[stage] += 1 # 각 스테이지에 있는 사람 구하기
        
    failures = []
    total = len(stages)
    
    for stage in range(1, N+1):
        reached = total
        not_cleared = stay[stage]
        rate = (not_cleared / reached) if reached > 0 else 0.0
        failures.append((stage, rate))
        total -= not_cleared
        
        failures.sort(key=lambda x: (-x[1], x[0]))
            
    
    

    return [stage for stage, failure in failures ]