package lesson3.Developers;

/**
 * Created by arpi on 05.02.2016.
 */
public abstract class ListPrinter {
    public static void printList (Developer[] developers) {
        StringBuilder sb = ListPrinter.title(developers[0]);
        for (Developer d : developers) {
            if (d != null) {
                sb.append(d.getName());
                sb.append(": ");
                sb.append(d.getBasicSalary());
                sb.append(" -> ");
                sb.append(d.getSalary());
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    public static void printList (Developer[] developers, int count){
        StringBuilder sb = ListPrinter.title(developers[0]);
        for (int i = 0; i<count; i++ ) {
                sb.append(developers[i].getName());
                sb.append(": ");
                sb.append(developers[i].getBasicSalary());
                sb.append(" -> ");
                sb.append(developers[i].getSalary());
                sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static StringBuilder title (Developer d){
        StringBuilder sb = new StringBuilder(); // !!!
        if (d instanceof JuniorDeveloper){
            sb.append("JUNIORS:\n");
        } else if (d instanceof SeniorDeveloper){
            sb.append("SENIORS:\n");
        } else if (d instanceof TeamLeadDeveloper) {
            sb.append("TEAMLEADS:\n");
        } else {
            sb.append("OTHER ONES");
        }
        return sb;
    }
}
