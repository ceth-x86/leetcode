def length_of_last_word(s: str) -> int:
    i = len(s) - 1
    while i >= 0 and s[i] == " ":
        i -= 1
    end = i
    while i >= 0 and s[i] != " ":
        i -= 1
    return end - i
