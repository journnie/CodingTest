T = int(input())
balloons = list(enumerate(map(int, input().split())))

move = 0
while T >= 0:
    idx, balloon = balloons.pop(move)
    print(idx+1, end=' ')

    T -= 1
    if T == 0:
        move = 0
        break
    if balloon > 0:
        move = (move + balloon - 1) % T
    elif balloon < 0:
        move = (move + balloon) % T
        