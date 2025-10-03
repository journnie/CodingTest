def solution(my_string, overwrite_string, s):
    answer = my_string[:s]+overwrite_string

    if(len(my_string) > s+len(overwrite_string)):
        answer = answer+ my_string[s+len(overwrite_string):]
    return answer