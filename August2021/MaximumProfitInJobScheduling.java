/*
Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3950/
*/
class Solution {
    private class Job{
        private int startTime;

        private int endTime;
        private int profit;

        public Job(int startTime, int endTime, int profit){

            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;

        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new Job(startTime[i],endTime[i], profit[i]));
        }

        Collections.sort(jobs, (a,b) -> ( a.endTime - b.endTime));
        // Key => Time, Value => profitTillTime
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int result = 0;

        for (Job currJob :  jobs) {
            Integer entryTillStartTime = map.floorKey(currJob.startTime);
            int maxProfitTillStartTime = entryTillStartTime == null ? 0 : map.get(entryTillStartTime);
            result = Math.max(result, maxProfitTillStartTime+currJob.profit);
            map.put(currJob.endTime, result);
        }
        return result;
    }
}
