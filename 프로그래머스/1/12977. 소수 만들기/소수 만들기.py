import itertools


def solution(nums):
    combination_list = list(itertools.combinations(nums, 3))
    sum_list = [sum(combination) for combination in combination_list]

    answer = 0

    for sum_num in sum_list:
        if sum_num == 1 or sum_num == 2:
            answer += 1
            continue

        prime = True
        for i in range(2, sum_num):
            if sum_num % i == 0:  
                prime = False
                break

        if prime:
            answer += 1

    return answer