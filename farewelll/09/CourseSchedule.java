package nine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Write your code here
        List[] xuyaodeqianti = new ArrayList[numCourses];
        int[] keweiqianti = new int[numCourses];
        for (int i = 0;i < numCourses; i++)
            xuyaodeqianti[i] = new ArrayList<Integer>();

        for (int i = 0; i < prerequisites.length; i++) {
            keweiqianti[prerequisites[i][0]] ++ ;
            xuyaodeqianti[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue queue = new LinkedList();
        for(int i = 0; i < keweiqianti.length; i++){
            if (keweiqianti[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int course = (int)queue.poll();
            count ++;
            int n = xuyaodeqianti[course].size();
            for(int i = 0; i < n; i++){
                int pointer = (int)xuyaodeqianti[course].get(i);
                keweiqianti[pointer]--;
                if (keweiqianti[pointer] == 0) {
                    queue.add(pointer);
                }
            }
        }

        return count == numCourses;
    }
}
