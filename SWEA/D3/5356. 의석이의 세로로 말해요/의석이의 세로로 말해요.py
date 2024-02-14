#import sys
T = int(input())
for test_case in range(1, T + 1):
    str_list = [[x for x in input()] for _ in range(5)]
    ans = ''
    length = len(str_list)
    for j in range(15):
        for i in range(length):
            ans += str_list[i][j]
            if j+1 >= len(str_list[i]):
                str_list[i].append('')

    print(f"#{test_case} {ans}")