def solution(n, lost, reserve):
    lost.sort()

    # 1. 실제로 여분의 체육복을 가져온 학생들만 선별한 리스트 생성
    real_reserve = set(reserve) - set(lost)
    reserve_list = list(real_reserve)
    no_gym = 0

    # 2. 잃어버린 학생 목록을 순회
    for lost_student in lost:
        # 3. 본인 스스로 챙겨온 학생은 스스로 빌리기
        if lost_student in reserve:
            continue
        # 4. 본인 기준 이전 학생이 여분 체육복을 가져온 친구라면 체육복을 빌리고 리스트에서 제거
        if lost_student-1 in reserve_list:
            reserve_list.remove(lost_student-1)
            continue
        # 5. 다음학생에게 4 과정 반복
        if lost_student+1 in reserve_list:
            reserve_list.remove(lost_student+1)
            continue
        # 6. 빌리지 못하면 못빌린 학생 수 +1
        no_gym += 1
    # 7. 총 학생 - 못 빌린 학생
    return n - no_gym
