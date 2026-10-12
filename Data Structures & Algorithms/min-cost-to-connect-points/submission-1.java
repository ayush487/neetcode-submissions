class Solution {
    private class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private class Distance implements Comparable<Distance> {
        final Point from;
        final Point to;
        final int distance;

        public Distance(Point from, Point to) {
            this.from = from;
            this.to = to;
            this.distance = Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
        }

        @Override
        public int compareTo(Distance o) {
            return this.distance - o.distance;
        }
    }

    private Map<Point, PriorityQueue<Distance>> minDistancePoint;

    public int minCostConnectPoints(int[][] points) {
        if (points.length == 1) return 0;

        Point[] pointArr = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            pointArr[i] = new Point(points[i][0], points[i][1]);
        }

        this.minDistancePoint = new HashMap<>();

        Distance minDistance = null;
        for (Point point1 : pointArr) {
            for (Point point2 : pointArr) {
                if (point1 == point2) continue;
                var d = new Distance(point1, point2);
                minDistancePoint.computeIfAbsent(point1, p -> new PriorityQueue<>()).offer(d);
                if (minDistance == null) minDistance = d;
                else if (d.distance < minDistance.distance) minDistance = d;
            }
        }

        Set<Point> visited = new HashSet<>();
        visited.add(minDistance.to);
        visited.add(minDistance.from);
        int totalDistance = minDistance.distance;

        while (visited.size() != points.length) {
            Distance d = getMinDistance(visited);
            totalDistance += d.distance;
            visited.add(d.to);
        }
        return totalDistance;
    }

    private Distance getMinDistance(Set<Point> visitedPoints) {
        Point bestOption = null;
        Distance bestDistance = null;
        Iterator<Point> iterator = visitedPoints.iterator();

        Point point = iterator.next();
        while (true) {
            if (visitedPoints.contains(minDistancePoint.get(point).peek().to)) {
                minDistancePoint.get(point).poll();
                continue;
            }
            Distance candidiateDistance = minDistancePoint.get(point).peek();
            if (bestDistance == null || bestDistance.distance > candidiateDistance.distance) {
                bestOption = point;
                bestDistance = candidiateDistance;
            }
            if(iterator.hasNext()) {
                point = iterator.next();
            }else break;
        }
        return minDistancePoint.get(bestOption).poll();
    }
}
