package invert_binary_tree

import (
	"reflect"
	"testing"
)

func intPtr(value int) *int {
	return &value
}

func buildTree(values []*int) *TreeNode {
	if len(values) == 0 || values[0] == nil {
		return nil
	}

	nodes := make([]*TreeNode, len(values))
	for i, value := range values {
		if value != nil {
			nodes[i] = &TreeNode{Val: *value}
		}
	}

	child := 1
	for _, node := range nodes {
		if node == nil {
			continue
		}
		if child < len(nodes) {
			node.Left = nodes[child]
			child++
		}
		if child < len(nodes) {
			node.Right = nodes[child]
			child++
		}
	}

	return nodes[0]
}

func serialize(root *TreeNode) []*int {
	if root == nil {
		return []*int{}
	}

	result := []*int{}
	queue := []*TreeNode{root}
	for len(queue) > 0 {
		node := queue[0]
		queue = queue[1:]

		if node == nil {
			result = append(result, nil)
			continue
		}

		result = append(result, intPtr(node.Val))
		queue = append(queue, node.Left, node.Right)
	}

	for len(result) > 0 && result[len(result)-1] == nil {
		result = result[:len(result)-1]
	}
	return result
}

func TestInvertTree(t *testing.T) {
	tests := []struct {
		name     string
		input    []*int
		expected []*int
	}{
		{"example 1", []*int{intPtr(4), intPtr(2), intPtr(7), intPtr(1), intPtr(3), intPtr(6), intPtr(9)}, []*int{intPtr(4), intPtr(7), intPtr(2), intPtr(9), intPtr(6), intPtr(3), intPtr(1)}},
		{"example 2", []*int{intPtr(2), intPtr(1), intPtr(3)}, []*int{intPtr(2), intPtr(3), intPtr(1)}},
		{"empty", []*int{}, []*int{}},
		{"single", []*int{intPtr(1)}, []*int{intPtr(1)}},
		{"only left", []*int{intPtr(1), intPtr(2)}, []*int{intPtr(1), nil, intPtr(2)}},
		{"only right", []*int{intPtr(1), nil, intPtr(2)}, []*int{intPtr(1), intPtr(2)}},
		{"negative values", []*int{intPtr(-1), intPtr(-2), intPtr(3)}, []*int{intPtr(-1), intPtr(3), intPtr(-2)}},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			result := serialize(invertTree(buildTree(tt.input)))
			if !reflect.DeepEqual(result, tt.expected) {
				t.Errorf("serialize(invertTree(%v)) = %v, want %v", tt.input, result, tt.expected)
			}
		})
	}
}
