#import sys
#sys.stdin = open("input.txt", "r")

N = int(input())

result = ''
numbers = list(range(1, N+1))

for num in numbers:
    str_num = str(num)
    if '3' not in str_num and '6' not in str_num and '9' not in str_num:
        result += str_num + ' '
        continue

    for char in str_num:
        if '3' == char:
            result += '-'
        elif '6' == char:
            result += '-'
        elif '9' == char:
            result += '-'
    result += ' '

print(result)

