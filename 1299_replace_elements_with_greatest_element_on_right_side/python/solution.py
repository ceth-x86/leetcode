def replace_elements(arr: list[int]) -> list[int]:
    right_max = -1
    for i in range(len(arr) - 1, -1, -1):
        right_max, arr[i] = max(right_max, arr[i]), right_max
    return arr
