def solution(array):
    answer = 0
    for i in array:
        i_str = str(i)
        for letter in i_str:
            if letter == '7':
                answer += 1
    return answer