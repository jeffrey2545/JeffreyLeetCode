class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        Map<Integer, Integer> prev = new HashMap<>();

        for (int num : nums) {
            dp.put(num, 1);
            prev.put(num, -1);
        }

        int lastNum = nums[0];

        for (int num : nums) {
            for (int factor : getFactors(num)) {
                if (!dp.containsKey(factor)) {
                    continue;
                }

                if (dp.get(num) < dp.get(factor) + 1) {
                    dp.put(num, dp.get(factor) + 1);
                    prev.put(num, factor);
                }
            }
            if (dp.get(num) > dp.get(lastNum)) {
                lastNum = num;
            }
        }

        return getPath(prev, lastNum);
    }
    
    public List<Integer> getFactors(int num) {
        List<Integer> factors = new ArrayList<>();

        if (num == 1) {
            return factors;
        }

        int factor = 1;
        while (factor * factor <= num) {
            if (num % factor == 0) {
                factors.add(factor);
                if (factor != 1 && factor * factor != num) {
                    factors.add(num / factor);
                }
            }
            factor++;
        }

        return factors;
    }

    public List<Integer> getPath(Map<Integer, Integer> prev, int lastNum) {
        List<Integer> path = new ArrayList<>();

        while (lastNum != -1) {
            path.add(lastNum);
            lastNum = prev.get(lastNum);
        }

        Collections.reverse(path);
        return path;
    }
}