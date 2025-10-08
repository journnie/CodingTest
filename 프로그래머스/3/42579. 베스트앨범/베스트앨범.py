from collections import *

def solution(genres, plays):
    answer = []
    genre_dict = defaultdict(list) # 장르 : [i, plays]
    play_dict = defaultdict(int) # 장르 : 장르총재생수
    # [장르, 장르 곡 수, 재생횟수]
    songs = [[] for _ in range(len(genres))]
    for i, genre in enumerate(genres):
        play_dict[genre] += plays[i]
        genre_dict[genre].append((i, plays[i]))
        
    sorted_genres = sorted(play_dict.items(), key = lambda x: x[1], reverse=True)
    
    for genre, _ in sorted_genres:
        sorted_songs = sorted(genre_dict[genre], key=lambda x:(-x[1], x[0]))
        answer.extend([idx for idx, _ in sorted_songs[:2]])
        
    return answer