#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    cards = [int(x) for x in input()]

    checked_cards = {}

    for i in range(N):
        card = cards[i]
        count = 0
        if card not in checked_cards:
            for j in range(i, N):
                same_card = cards[j]
                if same_card == card:
                    count += 1
            checked_cards[card] = count

    max_card = 0
    max_count = 0

    for card in checked_cards:
        if checked_cards[card] >= max_count:
            if card >= max_card:
                max_card = card
                max_count = checked_cards[card]


    result = f'{max_card} {max_count}'

    print(f'#{test_case} {result}')
