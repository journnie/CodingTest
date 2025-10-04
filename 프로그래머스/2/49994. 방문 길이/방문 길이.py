def is_valid(nx, ny):
    return 0 <= nx < 11 and 0 <= ny < 11

def move(x, y, dir):
    if dir == 'U':
        nx, ny = x, y+1
    elif dir == 'D':
        nx, ny = x, y-1
    elif dir == 'L':
        nx, ny = x-1, y
    elif dir == 'R':
        nx, ny = x+1, y
    return nx, ny

def solution(dirs):
    answer = set()
    
    x = 5
    y = 5
    
    for dir in dirs:
        nx, ny = move(x, y, dir)
        if not is_valid(nx, ny):  continue
        
        answer.add((nx, ny, x, y))
        answer.add((x, y, nx, ny))
        x, y = nx, ny
        
    
    return len(answer)/2