public class Integer {

    boolean[] arr = new boolean[101];

    public void Integer() {
        for (int i = 0; i < 101; i++) {
            this.arr[i] = false;
        }
    }

    public static Integer union(Integer set1, Integer set2) {
        Integer a = new Integer();

        for (int i = 0; i < 101; i++) {
            if (set1.arr[i] == true || set2.arr[i] == true) {
                a.arr[i] = true;
            }
        }

        return a;
    }

    public static Integer intersection(Integer set1, Integer set2) {
        Integer a = new Integer();

        for (int i = 0; i < 101; i++) {
            if (set1.arr[i] == false || set2.arr[i] == false) {
                //빈칸
            } else a.arr[i] = true;
        }

        return a;
    }

    public static void insertElement(Integer set, int k) {
        set.arr[k] = true;
    }

    public static void deleteElement(Integer set, int k) {
        set.arr[k] = false;
    }

    public static String toString(Integer set) {
        String stemp = "{ ";

        for (int i = 0; i < 101; i++) {
            if (set.arr[i] == true) {
                stemp = stemp + i + " ";
            }
        }

        if (stemp.equals("{ ")) {
            return "---";
        }
        stemp = stemp + "}";

        return stemp;
    }

    public static boolean isEqualTo(Integer set1, Integer set2) {
        for (int i = 0; i < 101; i++) {
            if (set1.arr[i] != set2.arr[i]) {
                return false;
            }
        }
        return true;
    }
}
