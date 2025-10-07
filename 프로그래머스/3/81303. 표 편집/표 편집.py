def solution(n, k, cmd):
    prev = [i - 1 for i in range(n)]
    next = [i + 1 for i in range(n)]
    next[n - 1] = -1
    deleted = []
    cur = k

    for c in cmd:
        action, *rest = c.split()
        if action in ('U', 'D'):
            move = int(rest[0])
            for _ in range(move):
                cur = prev[cur] if action == 'U' else next[cur]

        elif action == 'C':
            deleted.append(cur)
            p, q = prev[cur], next[cur]
            if p != -1:
                next[p] = q
            if q != -1:
                prev[q] = p
            cur = q if q != -1 else p

        elif action == 'Z':
            node = deleted.pop()
            p, q = prev[node], next[node]
            if p != -1:
                next[p] = node
            if q != -1:
                prev[q] = node

    answer = ['O'] * n
    for i in deleted:
        answer[i] = 'X'
    return ''.join(answer)
