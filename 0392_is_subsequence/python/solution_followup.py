from bisect import bisect_left
from collections import defaultdict


class SubsequenceChecker:
    """Preprocess t once, then check many s strings efficiently."""

    def __init__(self, t: str) -> None:
        self.index_map: dict[str, list[int]] = defaultdict(list)
        for i, ch in enumerate(t):
            self.index_map[ch].append(i)

    def is_subsequence(self, s: str) -> bool:
        pos = 0  # current position in t (must match at or after this index)
        for ch in s:
            indices = self.index_map.get(ch)
            if indices is None:
                return False
            idx = bisect_left(indices, pos)
            if idx == len(indices):
                return False
            pos = indices[idx] + 1
        return True
