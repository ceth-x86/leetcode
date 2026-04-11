WINDOW_SIZE = 10


def find_repeated_dna_sequences(s: str) -> list[str]:
    if len(s) < WINDOW_SIZE:
        return []

    seen: set[str] = set()
    repeated: set[str] = set()
    result: list[str] = []

    for start in range(len(s) - WINDOW_SIZE + 1):
        fragment = s[start:start + WINDOW_SIZE]
        if fragment in seen:
            if fragment not in repeated:
                repeated.add(fragment)
                result.append(fragment)
        else:
            seen.add(fragment)

    return result
