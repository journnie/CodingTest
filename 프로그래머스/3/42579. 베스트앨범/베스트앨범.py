from collections import *

def solution(genres, plays):
    answer = []
    genre_dict = defaultdict(list) # 장르 : [i, plays]
    play_dict = defaultdict(int) # 장르 : 장르총재생수

    for i, (g, p) in enumerate(zip(genres, plays)):
        genre_dict[g].append((i, p))
        play_dict[g] += p

    for (k, v) in sorted(play_dict.items(), key=lambda x:x[1], reverse=True):
        for (i, p) in sorted(genre_dict[k], key=lambda x:x[1], reverse=True)[:2]:
            answer.append(i)

    return answer