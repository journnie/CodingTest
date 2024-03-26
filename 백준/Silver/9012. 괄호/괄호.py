T = int(input())
test_cases = [list(map(str, input())) for _ in range(T)]

for a in test_cases:
    FLAG = True
    stack = []
    for char in a:
        if char == '(':
            stack.append(char)
        else:
            if not stack:
                print('NO')
                FLAG = False
                break
            stack.pop()
    if not FLAG:
        continue
    if stack:
        print('NO')
    else:
        print('YES')
