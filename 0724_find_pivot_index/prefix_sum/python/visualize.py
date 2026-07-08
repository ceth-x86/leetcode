from solution import Solution

def visualize_pivot_index():
    nums = [1, 7, 3, 6, 5, 6]
    print(f"Finding pivot index for: {nums}")
    
    total_sum = sum(nums)
    left_sum = 0
    
    for i, num in enumerate(nums):
        right_sum = total_sum - left_sum - num
        print(f"Index {i} (val={num}): left_sum={left_sum}, right_sum={right_sum}")
        if left_sum == right_sum:
            print(f"-> Pivot found at index {i}!")
            return
        left_sum += num
        
    print("-> No pivot index found.")

if __name__ == "__main__":
    visualize_pivot_index()
