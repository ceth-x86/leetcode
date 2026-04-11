WINDOW_SIZE = 10
ENCODE = {"A": 0, "C": 1, "G": 2, "T": 3}


def find_repeated_dna_sequences(s: str) -> list[str]:
    n = len(s)
    if n <= WINDOW_SIZE:
        return []

    nums = [ENCODE[ch] for ch in s]

    bitmask = 0
    seen: set[int] = set()
    output: set[str] = set()

    for start in range(n - WINDOW_SIZE + 1):
        if start == 0:
            for index in range(WINDOW_SIZE):
                bitmask = (bitmask << 2) | nums[index]
        else:
            bitmask <<= 2
            bitmask |= nums[start + WINDOW_SIZE - 1]
            bitmask &= ~(3 << (2 * WINDOW_SIZE))

        if bitmask in seen:
            output.add(s[start:start + WINDOW_SIZE])
        else:
            seen.add(bitmask)

    return list(output)
