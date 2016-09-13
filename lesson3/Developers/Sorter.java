package lesson3.Developers;

/**
 * Created by arpi on 05.02.2016.
 */
public abstract class Sorter {
    /**C������ � ���������� ��������� ������ � ������� � ������ ������ �������� ���������� ��� ��-�� ��������� ����*/
    public static Developer [][] sortDevelopers (Developer [] developers){
        int juniorCounter = 0;
        int seniorCounter = 0;
        int teamLeadsCounter = 0;

        Developer [][] devList  = new Developer [3][developers.length];

        for (Developer dev : developers){
            if (dev instanceof JuniorDeveloper){
                devList[0][juniorCounter++] = dev;
            }  else if (dev instanceof SeniorDeveloper){
                devList[1][seniorCounter++] = dev;
            } else if (dev instanceof TeamLeadDeveloper){
                devList[2][teamLeadsCounter++] = dev;
            }
        }
    return devList;
    }

    /**C������ � ���������� ������������, ��� ������ ����������� ����������*/
    public static StringBuilder sortedDevPrint (Developer[][] developers) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 3; j++){
            switch (j){
                case 0: sb.append("JUNIORS:\n");
                    break;
                case 1: sb.append("SENIORS:\n");
                    break;
                case 2: sb.append("TEAMLEADS:\n");
                    break;
            }
            for (int i = 0; i<developers[j].length; i++){
                if (developers[j][i]!=null) {
                    sb.append(developers[j][i].getName());
                    sb.append(": ");
                    sb.append(developers[j][i].getBasicSalary());
                    sb.append(" -> ");
                    sb.append(developers[j][i].getSalary());
                    sb.append("\n");
                }
            }
        }
    return sb;
    }
}
