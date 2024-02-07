def solution(arr):
    answer = []
    # 아래에 코드를 작성해주세요.
    for i in range(len(arr)):
        number = arr[i]
        if i != 0:
            if arr[i-1] == number:
                answer.pop()
        answer.append(number)

    return answer