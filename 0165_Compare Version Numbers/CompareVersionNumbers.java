class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arrOfVer1 = version1.split("\\.");
        String[] arrOfVer2 = version2.split("\\.");
        int i = 0;
        while(i < Math.max(arrOfVer1.length, arrOfVer2.length)) {
            int v1 = i >= arrOfVer1.length ? 0 : Integer.parseInt(arrOfVer1[i]);
            int v2 = i >= arrOfVer2.length ? 0 : Integer.parseInt(arrOfVer2[i]);
            if(v1 < v2) return -1;
            else if(v1 > v2) return 1;
            i++;
        }

        return 0;
    }
}