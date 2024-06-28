def solution(num_list):
    odds = 0
    evens = 0
    for i in range(len(num_list)):
        if i % 2 == 0:
            evens += num_list[i]
        else:
            odds += num_list[i]

    return max(odds, evens)