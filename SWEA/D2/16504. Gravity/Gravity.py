#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input()) # 방의 가로길이
    box_list = list(map(int, input().split())) # 쌓여있는 상자 수

    # for문 안 쪽에 코드를 작성해주세요
    max_fall = 0

    for i in range(N):
        fall = 0
        for j in range(i+1, N):
            if box_list[i] > box_list[j]:
                fall += 1

            if fall > max_fall:
                max_fall = fall

    result = max_fall
    print(f'#{test_case} {result}')

