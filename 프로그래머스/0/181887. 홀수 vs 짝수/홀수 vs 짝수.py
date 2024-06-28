def solution(num_list):
    odds = sum(num_list[::2])
    evens = sum(num_list[1::2])
    return max(odds, evens)
