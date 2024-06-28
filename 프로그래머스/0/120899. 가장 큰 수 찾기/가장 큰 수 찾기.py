def solution(array):
    # 아래에 코드를 작성해주세요.
    answer = [array[0], 0]
    for idx, num in enumerate(array):
        if num >= answer[0]:
            answer[0] = num
            answer[1] = idx
    return answer
