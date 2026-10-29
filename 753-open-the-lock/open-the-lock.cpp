
class Solution {
public:
    int openLock(vector<string>& deadends, string target) {

        unordered_set<string> dead(deadends.begin(), deadends.end());

        string start = "0000";

        if (dead.count(start)) {
            return -1;
        }

        queue<string> q;
        unordered_set<string> visited;

        q.push(start);
        visited.insert(start);

        int turns = 0;

        while (!q.empty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                string current = q.front();
                q.pop();

                if (current == target) {
                    return turns;
                }

                for (int j = 0; j < 4; j++) {
                    string up = current;
                    string down = current;

                    up[j] = (current[j] - '0' + 1) % 10 + '0';
                    down[j] = (current[j] - '0' + 9) % 10 + '0';

                    if (!dead.count(up) && !visited.count(up)) {
                        q.push(up);
                        visited.insert(up);
                    }

                    if (!dead.count(down) && !visited.count(down)) {
                        q.push(down);
                        visited.insert(down);
                    }
                }
            }

            turns++;
        }

        return -1;
    }
};
