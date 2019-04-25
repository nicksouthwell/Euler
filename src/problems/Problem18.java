package problems;

import common.NumberTriangle;

public class Problem18 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 18 - Maximum path sum I\n" +
                "-------------------------------\n" +
                "By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.\n" +
                "\t\t\t   3\n" +
                "\t\t\t  7 4\n" +
                "\t\t\t 2 4 6\n" +
                "\t\t\t8 5 9 3\n" +
                "That is, 3 + 7 + 4 + 9 = 23.\n" +
                "\n" +
                "Find the maximum total from top to bottom of the triangle below:\n" +
                "\t\t                            75\n" +
                "\t\t                          95  64\n" +
                "\t\t                        17  47  82\n" +
                "\t\t                      18  35  87  10\n" +
                "\t\t                    20  04  82  47  65\n" +
                "\t\t                  19  01  23  75  03  34\n" +
                "\t\t                88  02  77  73  07  63  67\n" +
                "\t\t              99  65  04  28  06  16  70  92\n" +
                "\t\t            41  41  26  56  83  40  80  70  33\n" +
                "\t\t          41  48  72  33  47  32  37  16  94  29\n" +
                "\t\t        53  71  44  65  25  43  91  52  97  51  14\n" +
                "\t\t      70  11  33  28  77  73  17  78  39  68  17  57\n" +
                "\t\t    91  71  52  38  17  14  91  43  58  50  27  29  48\n" +
                "\t\t  63  66  04  68  89  53  67  30  73  16  69  87  40  31\n" +
                "\t\t04  62  98  27  23  09  70  98  73  93  38  53  60  04  23\n" +
                "NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route.\n" +
                "However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force.";
    }

    @Override
    public Integer solution() {
        NumberTriangle nt = new NumberTriangle();
        nt.addRow(75);
        nt.addRow(95, 64);
        nt.addRow(17, 47, 82);
        nt.addRow(18, 35, 87, 10);
        nt.addRow(20, 4, 82, 47, 65);
        nt.addRow(19, 1, 23, 75, 3, 34);
        nt.addRow(88, 2, 77, 73, 7, 63, 67);
        nt.addRow(99, 65, 4, 28, 6, 16, 70, 92);
        nt.addRow(41, 41, 26, 56, 83, 40, 80, 70, 33);
        nt.addRow(41, 48, 72, 33, 47, 32, 37, 16, 94, 29);
        nt.addRow(53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14);
        nt.addRow(70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57);
        nt.addRow(91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48);
        nt.addRow(63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31);
        nt.addRow(04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23);

        while (nt.coalesceMax() > 1) ;

        return nt.top();
    }

}
