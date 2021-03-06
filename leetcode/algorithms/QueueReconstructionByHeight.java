/*
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person 
 * and k is the number of people in front of this person who have a height 
 * greater than or equal to h. Write an algorithm to reconstruct the queue.

 * Note:
 * The number of people is less than 1,100.
 * 
 * Example
 * 
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        for (int i = 1; i < people.length; ++i) {
            for (int j = 0, count = 0; j < i; ++j) {
                if (count == people[i][1]) {
                    int[] tmp = {people[i][0], people[i][1]};
                    for (int k = i; k > j; --k) {
                        people[k] = people[k - 1];
                    }
                    people[j] = tmp;
                    break;
                }
                if (people[j][0] >= people[i][0]) {
                    count++;
                }
            }
        }
        return people;
    }

/*****************************************************************************/

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> list = new LinkedList<int[]>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[people.length][]);
    }

}
