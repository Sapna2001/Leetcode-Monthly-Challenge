/*
You are given two integers n and k and two integer arrays speed and efficiency both of length n. There are n engineers numbered from 1 to n. speed[i] and 
efficiency[i] represent the speed and efficiency of the ith engineer respectively.

Choose at most k different engineers out of the n engineers to form a team with the maximum performance.

The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.

Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 109 + 7.

Link: https://leetcode.com/explore/featured/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3768/
*/

class Solution {
    private class Engineer {
        private int speed;
        private int efficiency;
        
        public Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Engineer> engineers = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)
            engineers.add(new Engineer(speed[i], efficiency[i]));
        engineers.sort((a,b) -> b.efficiency - a.efficiency);
        PriorityQueue<Engineer> currentTeam = new PriorityQueue<>((a,b) -> a.speed - b.speed);
        
        long speedSum = 0;
        long maxPerformance = 0;
        
        for(Engineer engineer : engineers) {
            if(currentTeam.size() == k) {
                Engineer minSpeed = currentTeam.poll();
                speedSum -= minSpeed.speed;
            }
            currentTeam.add(engineer);
            speedSum += engineer.speed;
            
            long currentPerformance = speedSum * (long) engineer.efficiency;
            maxPerformance = Math.max(maxPerformance, currentPerformance);
        }
        return (int)(maxPerformance % 1000000007);
    }
}
