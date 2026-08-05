/**
 * @param {number} n
 * @param {number} k
 * @param {number[][]} invocations
 * @return {number[]}
 */
var remainingMethods = function (n, k, invocations) {

    const graph = Array.from({ length: n }, () => []);
    const reverse = Array.from({ length: n }, () => []);

    for (const [u, v] of invocations) {
        graph[u].push(v);
        reverse[v].push(u);
    }

    const suspicious = new Array(n).fill(false);

    function dfs(node) {
        if (suspicious[node]) return;

        suspicious[node] = true;

        for (const next of graph[node]) {
            dfs(next);
        }
    }

    dfs(k);

    for (let i = 0; i < n; i++) {

        if (!suspicious[i]) continue;

        for (const parent of reverse[i]) {
            if (!suspicious[parent]) {
                return [...Array(n).keys()];
            }
        }
    }

    const ans = [];

    for (let i = 0; i < n; i++) {
        if (!suspicious[i]) {
            ans.push(i);
        }
    }

    return ans;
};