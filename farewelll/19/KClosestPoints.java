package nineteen;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {
    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        PriorityQueue<Point> queue = new PriorityQueue<>(10, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return (b.x * b.x + b.y * b.y) - (a.x * a.x + a.y * a.y);
            }
        });

        for (int i = 0; i < points.length; i++) {
            if (i < k)
                queue.offer(points[i]);
            else {
                Point tmp = queue.peek();
                if ((points[i].x * points[i].x + points[i].y * points[i].y) - (tmp.x * tmp.x + tmp.y * tmp.y) < 0) {
                    queue.poll();
                    queue.offer(points[i]);
                }
            }
        }
        Point[] data = new Point[k];
        int index = 0;
        while (!queue.isEmpty()) {
            data[index] = queue.poll();
            index++;
        }
        return data;
    }
}
