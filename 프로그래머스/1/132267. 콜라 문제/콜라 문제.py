def solution(a, b, n):
    answer = 0
    bottle = n
    while bottle >= a:
        giving_set = bottle // a
        get = b * giving_set
        bottle = bottle % a + get
        answer += get
        print(giving_set, get, bottle, answer)
    return answer