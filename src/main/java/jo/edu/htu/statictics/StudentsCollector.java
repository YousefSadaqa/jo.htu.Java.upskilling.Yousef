package jo.edu.htu.statictics;

import java.time.Year;
import java.util.ArrayList;

public class StudentsCollector implements StatisticsCollector<Student> {
    @Override
    public Iterable<Statistic> collect(Iterable<Student> cases) {
        ArrayList<Statistic> statistics = new ArrayList<>();
        Integer cisCount = 0, csCount = 0, yearCountMore2016 = 0, yearCountless2016 = 0, maleCount = 0, femaleCount = 0;
        for (Student student : cases) {
            if (student.getMajor().equals(("CIS")))
                cisCount++;
            if (student.getMajor().equals(("Computer Science")))
                csCount++;
            if (student.getGraduationYear().isAfter(Year.of(2016)))
                yearCountMore2016++;
            if (student.getGraduationYear().isBefore(Year.of(2017)))
                yearCountless2016++;
            if (student.getGender().equals(Gender.MALE))
                maleCount++;
            if (student.getGender().equals((Gender.FEMALE)))
                femaleCount++;
        }
        addStatistics(statistics, "CIS major", cisCount);

        addStatistics(statistics, "Computer Science major", csCount);

        addStatistics(statistics, "graduation year <= 2016", yearCountless2016);

        addStatistics(statistics, "graduation year > 2016", yearCountMore2016);

        addStatistics(statistics, "Males", maleCount);

        addStatistics(statistics, "Females", femaleCount);


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
