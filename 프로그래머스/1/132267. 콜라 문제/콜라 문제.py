def solution(a, b, n):
    answer = 0
    empty = n

    while empty >= a:
        new = empty // a * b
        left = empty % a
        empty = new + left
        answer += new
    return answer