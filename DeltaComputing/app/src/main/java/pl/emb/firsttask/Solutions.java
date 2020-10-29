package pl.emb.firsttask;

public class Solutions {
    public String linearEquation(double x) {
            return "The linear equation has one solution: " + x;
    }

    public String identityEquation() {
        return "Identity equation";
    }

    public String inconsistantEquation() {
        return "Inconsistant equation";
    }

    public String quadraticEquation(double squareDiscriminant) {
            return "The quadratic equation has no roots. The square discriminant equals "
                    + squareDiscriminant;
    }

    public String quadraticEquation(double x, double squareDiscriminant) {
        return "The quadratic equation has one root, which is " + x +
                "The square discriminant equals " + squareDiscriminant;
    }

    public String quadraticEquation(double x1, double x2, double squareDiscriminant) {
        return "The quadratic equation has two roots. The first root is " + x1
                + " ,the second root is " + x2 + ". The square discriminant equals "
                + squareDiscriminant;
    }

}
