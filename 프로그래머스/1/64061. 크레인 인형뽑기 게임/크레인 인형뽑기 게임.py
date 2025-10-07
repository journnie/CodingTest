def solution(board, moves):
    n = len(board)
    game = [[] for _ in range(n)]
    basket = []
    popped = 0
    
    for c in range(n):
        for r in range(n-1, -1, -1):
            if board[r][c] != 0:
                game[c].append(board[r][c])
                
    for mv in moves:
        c = mv - 1
        if not game[c]: continue
        stuff = game[c].pop()
        if basket and stuff == basket[-1]:
            basket.pop()
            popped += 2
        else:
            basket.append(stuff)
    
    return popped