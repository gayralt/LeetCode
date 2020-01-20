package main.java.match._177;

import java.util.*;

public class WatchedVideosByFriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        boolean[] friendsJudge = new boolean[friends.length];
        LinkedList<Integer> current = new LinkedList<>();
        LinkedList<Integer> last = new LinkedList<>();
        LinkedList<String> result=new LinkedList<>();
        last.offer(id);
        friendsJudge[id]=true;
        int friendId;
        //根据级别获取朋友的id
        for (int i = 0; i < level; i++) {
            while (!last.isEmpty()){
                friendId=last.poll();
                intputFriends(current,friends[friendId],friendsJudge);
            }
            last=current;
            current=new LinkedList<>();
        }
        Map<String,Integer> map=new HashMap<>();
        List<String> videos;
        //获得影片观影次数
        for (int i = 0; i < last.size(); i++) {
            videos=watchedVideos.get(last.get(i));
            for (int j = 0; j < videos.size(); j++) {
                if (map.containsKey(videos.get(j))){
                    map.replace(videos.get(j),map.get(videos.get(j))+1);
                }else {
                    map.put(videos.get(j),1);
                }
            }
        }
        //获得结果
        for (String s:map.keySet()) {
            result.add(s);
        }
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1)!=map.get(o2))
                return map.get(o1)-map.get(o2);
                return o1.compareTo(o2);
            }
        });
        //排序
        return result;
    }

    private void intputFriends(LinkedList<Integer> list, int[] friends, boolean[] friendsJudge){
        for (int i = 0; i < friends.length; i++) {
            if (!friendsJudge[friends[i]]) {
                list.add(friends[i]);
                friendsJudge[friends[i]] = true;
            }
        }
    }

    public static void main(String[] args) {
        WatchedVideosByFriends friends=new WatchedVideosByFriends();
    }
}
