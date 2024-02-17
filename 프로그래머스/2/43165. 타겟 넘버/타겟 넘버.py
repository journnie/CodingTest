def solution(numbers, target):
    global answer
    answer = 0

    def dfs(numbers, target, idx, res):
        global answer

        if idx == len(numbers):
            if res == target:
                answer += 1
            return

        dfs(numbers, target, idx + 1, res+numbers[idx])
        dfs(numbers, target, idx + 1, res-numbers[idx])

    dfs(numbers, target, 1, numbers[0])
    dfs(numbers, target, 1, -1 * numbers[0])

    return answer
