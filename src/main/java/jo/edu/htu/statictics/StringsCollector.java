package jo.edu.htu.statictics;

import java.util.*;

public class StringsCollector implements StatisticsCollector<String> {

    @Override
    public Iterable<Statistic> collect(Iterable<String> cases) {

        ArrayList<Statistic> statistics = new ArrayList<>();
        int upper = 0, lower = 0, spaces = 0, special = 0, number = 0;
        for (String str : cases)
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch >= 'A' && ch <= 'Z')
                    upper++;
                else if (ch >= 'a' && ch <= 'z')
                    lower++;
                else if (ch == ' ')
                    spaces++;
                else if (ch >= '0' && ch <= '9')
                    number++;
                else
                    special++;

            }
        addStatistics(statistics, "upper case letters", upper);
        addStatistics(statistics, "lower case letters", lower);
        addStatistics(statistics, "spaces count", spaces);
        addStatistics(statistics, "non-word characters", special);

        return statistics;
    }

    private void addStatistics(ArrayList<Statistic> statistics, String name, Integer matched) {
        statistics.add(new Statistic() {
            @Override
            public String name() {
                return name;
            }

            @Override
            public Integer matchedCases() {
                return matched;
            }

            @Override
            public int compareTo(Statistic statistic) {
                return 0;
            }
        });
    }
}
