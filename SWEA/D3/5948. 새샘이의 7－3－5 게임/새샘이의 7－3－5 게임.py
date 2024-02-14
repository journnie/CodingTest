#import sys
#sys.stdin = open("practice_3.txt", "r")

def get_comb(arr, n):
    res = []
    if n == 0:
        return [[]]

    for i in range(len(arr)):
        for rest in get_comb(arr[i+1:], n-1):
            res.append([arr[i]] + rest)
    return res

T = int(input())
for test_case in range(1, T + 1):
    arr = list(map(int, input().split()))
    comb_list = get_comb(arr, 3)
    sum_set = set()
    for comb in comb_list:
        sum_set.add(sum(comb))
    sorted_sum = sorted(list(sum_set), reverse=True)
    ans = sorted_sum[4]

    print(f"#{test_case} {ans}")

