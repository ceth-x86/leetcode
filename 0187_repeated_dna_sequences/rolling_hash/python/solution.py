WINDOW_SIZE = 10
WINDOW_MASK = (1 << (WINDOW_SIZE * 2)) - 1
ENCODE = {"A": 0, "C": 1, "G": 2, "T": 3}


def find_repeated_dna_sequences(s: str) -> list[str]:
    if len(s) < WINDOW_SIZE:
        return []

    rolling = 0
    seen: set[int] = set()
    repeated: set[int] = set()
    result: list[str] = []

    for index, ch in enumerate(s):
        rolling = ((rolling << 2) | ENCODE[ch]) & WINDOW_MASK
        if index < WINDOW_SIZE - 1:
            continue

        start = index - WINDOW_SIZE + 1
        if rolling in seen:
            if rolling not in repeated:
                repeated.add(rolling)
                result.append(s[start:index + 1])
        else:
            seen.add(rolling)

    return result
