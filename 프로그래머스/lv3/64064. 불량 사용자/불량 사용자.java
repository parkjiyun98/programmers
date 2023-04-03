import java.util.*;
class Solution {
    HashSet<HashSet<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        //boolean[] visited = new boolean[user_id.length];
        HashSet<String> set = new HashSet<>();
        dfs(set, 0, user_id, banned_id);

        return result.size();
    }
    public void dfs(HashSet<String> set, int depth, String[] user_id, String[] banned_id){
        
        if(depth == banned_id.length){
            result.add(set);
            return;
        }
        for (int i = 0; i < user_id.length; i++) {
            if (set.contains(user_id[i])) {
                continue;
            }

            if (check(user_id[i], banned_id[depth])) {
                set.add(user_id[i]);
                dfs(new HashSet<>(set), depth + 1, user_id, banned_id);
                set.remove(user_id[i]);
            }
        }
    }
    boolean check(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        boolean b = true;
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                b = false;
                break;
            }
        }

        return b;
    }
}