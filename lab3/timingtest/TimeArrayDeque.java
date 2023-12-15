package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

public class TimeArrayDeque {
        private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
            System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
            System.out.printf("------------------------------------------------------------\n");
            for (int i = 0; i < Ns.size(); i += 1) {
                int N = Ns.get(i);
                double time = times.get(i);
                int opCount = opCounts.get(i);
                double timePerOp = time / opCount * 1e6;
                System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
            }
        }

        public static void main(String[] args) {
            timeAListConstruction();
        }

        public static void timeAListConstruction() {
            int iterationBeginCount = 1000;
            int experimentCount = 15;

            AList<Integer> funcCallCount = new AList<>();
            AList<Double> times = new AList<>();
            AList<Integer> opCounts = new AList<>();

            for (int i = iterationBeginCount, expriment = 0; expriment < experimentCount; i += i, expriment += 1) {
                Stopwatch sp = new Stopwatch();
                ArrayDeque<Integer> aList = new ArrayDeque<>();
                for (int j = 0; j < i; j++) {
                    aList.addLast(j);
                }
                Double usedTimeInSecond = sp.elapsedTime();
                funcCallCount.addLast(i);
                times.addLast(usedTimeInSecond);
                opCounts.addLast(i);
            }
            printTimingTable(funcCallCount, times, opCounts);
        }
    }


