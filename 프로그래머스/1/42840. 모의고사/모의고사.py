def solution(answers):
    # 정답의 길이
    answer_len = len(answers)
    # 수포자들의 찍기 패턴
    first = [1, 2, 3, 4, 5]
    second = [2, 1, 2, 3, 2, 4, 2, 5]
    third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    people = [first, second, third]
    score_list = [0] * len(people)  # 정답 맞히면 점수 올라감

    for i in range(answer_len):  # i번 문제
        for person in people:
            if person[i % len(person)] == answers[i]:  # 정답일 시 점수 기록
                person_idx = people.index(person)
                score_list[person_idx] += 1

    max_score = max(score_list)
    answer = []  # 최고점 사람 기록

    for i in range(len(score_list)):
        if score_list[i] == max_score: # 최고점인 사람 추출
            answer.append(i + 1)

    return answer