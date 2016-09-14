package lesson3.Developers;

public class Main {
    public static void main(String[] args) {
        Developer[] list = {
                new JuniorDeveloper("Mike", 1000, 0),
                new JuniorDeveloper("Dima", 1200, 1),
                new JuniorDeveloper("Vova", 1300, 2),
                new JuniorDeveloper("Vova", 1300, 2),

                new SeniorDeveloper("Jack", 1500, 5),
                new SeniorDeveloper("Nick", 1600, 5),
                new SeniorDeveloper("Rick", 200, 2),
                new SeniorDeveloper("Mack", 1200, 5),

                new TeamLeadDeveloper("Robby", 1000, 7),

                new MiddleDeveloper("Felix",1500, 5),
                new MiddleDeveloper("Mark",500, 2)
        };

/*        int juniorCounter = 0;
        int seniorCounter = 0;
        int teamLeadsCounter = 0;
        Developer[] juniorList = new Developer[list.length];
        Developer[] seniorList = new Developer[list.length];
        Developer[] teamLeadList = new Developer[list.length];
        for (Developer dev:list){
            if (dev instanceof JuniorDeveloper) {
                juniorList[juniorCounter++]=dev;
            } else if (dev instanceof SeniorDeveloper) {
                seniorList[seniorCounter++]=dev;
            } else if (dev instanceof TeamLeadDeveloper) {
                teamLeadList[teamLeadsCounter++]=dev;
            }
        }

        //Вывод
        ListPrinter.printList(juniorList);
        ListPrinter.printList(seniorList,seniorCounter);
        ListPrinter.printList(teamLeadList,teamLeadsCounter);*/

        Developer[][] sortedList = Sorter.sortDevelopers(list);
        System.out.println((Sorter.sortedDevPrint(sortedList)).toString());

       
       /* StringBuilder sb = new StringBuilder(); // !!!
        for (Developer d : list) {

            if ((d instanceof SeniorDeveloper) && (d.getSalary() > 1500)){
                sb.append(d.getName());
                sb.append(": ");
                sb.append(d.getBasicSalary());
                sb.append(" -> ");
                sb.append(d.getSalary());
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
        System.out.println("End of work");*/
    }
}
