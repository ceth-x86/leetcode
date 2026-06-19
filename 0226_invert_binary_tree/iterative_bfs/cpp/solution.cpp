#include <cassert>
#include <iostream>
#include <memory>
#include <optional>
#include <queue>
#include <string>
#include <utility>
#include <vector>

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;

    explicit TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

TreeNode* invertTree(TreeNode* root) {
    if (root == nullptr) {
        return nullptr;
    }

    std::queue<TreeNode*> queue;
    queue.push(root);

    while (!queue.empty()) {
        TreeNode* node = queue.front();
        queue.pop();

        std::swap(node->left, node->right);
        if (node->left != nullptr) {
            queue.push(node->left);
        }
        if (node->right != nullptr) {
            queue.push(node->right);
        }
    }

    return root;
}

TreeNode* buildTree(const std::vector<std::optional<int>>& values, std::vector<std::unique_ptr<TreeNode>>& storage) {
    if (values.empty() || !values[0].has_value()) {
        return nullptr;
    }

    std::vector<TreeNode*> nodes(values.size(), nullptr);
    storage.reserve(values.size());
    for (std::size_t i = 0; i < values.size(); ++i) {
        if (values[i].has_value()) {
            storage.push_back(std::make_unique<TreeNode>(*values[i]));
            nodes[i] = storage.back().get();
        }
    }

    std::size_t child = 1;
    for (TreeNode* node : nodes) {
        if (node == nullptr) {
            continue;
        }
        if (child < nodes.size()) {
            node->left = nodes[child++];
        }
        if (child < nodes.size()) {
            node->right = nodes[child++];
        }
    }

    return nodes[0];
}

std::vector<std::optional<int>> serialize(TreeNode* root) {
    if (root == nullptr) {
        return {};
    }

    std::vector<std::optional<int>> result;
    std::queue<TreeNode*> queue;
    queue.push(root);

    while (!queue.empty()) {
        TreeNode* node = queue.front();
        queue.pop();

        if (node == nullptr) {
            result.push_back(std::nullopt);
            continue;
        }

        result.push_back(node->val);
        queue.push(node->left);
        queue.push(node->right);
    }

    while (!result.empty() && !result.back().has_value()) {
        result.pop_back();
    }
    return result;
}

struct TestCase {
    std::string name;
    std::vector<std::optional<int>> input;
    std::vector<std::optional<int>> expected;
};

int main() {
    std::vector<TestCase> tests = {
        {"example 1", {4, 2, 7, 1, 3, 6, 9}, {4, 7, 2, 9, 6, 3, 1}},
        {"example 2", {2, 1, 3}, {2, 3, 1}},
        {"empty", {}, {}},
        {"single", {1}, {1}},
        {"only left", {1, 2}, {1, std::nullopt, 2}},
        {"only right", {1, std::nullopt, 2}, {1, 2}},
        {"negative values", {-1, -2, 3}, {-1, 3, -2}},
    };

    for (const auto& test : tests) {
        std::vector<std::unique_ptr<TreeNode>> storage;
        TreeNode* root = buildTree(test.input, storage);
        assert(serialize(invertTree(root)) == test.expected);
        std::cout << "PASS: " << test.name << std::endl;
    }

    std::cout << "\nAll tests passed!" << std::endl;
    return 0;
}
