import problems.Problem;

public class Main {

    public static void main(String[] args) {
        Problem problem = loadProblem(14);
        System.out.println(problem.getDescription());
        System.out.println();
        System.out.print("Computing...");
        System.out.println("\nAnswer: " + problem.solution());
    }

    private static Problem loadProblem(int number) {
        String className = "problems.Problem" + number;
        Problem problem = null;
        try {
            Class<?> clazz = Class.forName(className);
            problem = (Problem) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return problem;
    }
}
