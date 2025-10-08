from collections import *

def solution(record):
    answer = []
    users = defaultdict()
    for r in record:
        action, *rest = r.split()
        user_id = rest[0]
        if action == 'Enter':
            users[user_id] = rest[1]
            # answer.append(user_id+'님이 들어왔습니다.')

        # elif action == 'Leave':
            # answer.append(user_id+'님이 나갔습니다.')
            
        elif action == 'Change':
            users[user_id] = rest[1]


    for r in record:
        action, *rest = r.split()
        user_id = rest[0]
        if action == 'Enter':
            answer.append(users[user_id]+'님이 들어왔습니다.')

        elif action == 'Leave':
            answer.append(users[user_id]+'님이 나갔습니다.')
        
  
    return answer