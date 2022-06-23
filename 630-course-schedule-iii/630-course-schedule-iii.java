class Solution {
    public int scheduleCourse(int[][] courses) {
        
        /**
            Time complexity : O(n*count)O(n∗count). We iterate over a total of ne elements of the coursescourses array. For every element, we can traverse backwards upto atmost countcount(final value) number of elements.

            Space complexity : O(1)O(1). Constant extra space is used.
        */
        
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int time = 0, count = 0;
        for (int i = 0; i < courses.length; i++) {
            if (time + courses[i][0] <= courses[i][1]) {
                time += courses[i][0];
                courses[count++] = courses[i];
            } else {
                int max_i = i;
                for (int j = 0; j < count; j++) {
                    if (courses[j][0] > courses[max_i][0])
                        max_i = j;
                }
                if (courses[max_i][0] > courses[i][0]) {
                    time += courses[i][0] - courses[max_i][0];
                    courses[max_i] = courses[i];
                }
            }
        }
        return count;
    }
}