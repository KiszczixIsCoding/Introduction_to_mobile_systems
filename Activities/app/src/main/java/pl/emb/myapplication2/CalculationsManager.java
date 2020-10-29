package pl.emb.myapplication2;

import java.util.ArrayList;

import pl.emb.myapplication2.Solutions;

public class CalculationsManager {

    public double countSquareDiscriminant(double a, double b, double c) {
        return b*b - 4*a*c;
    }

    public ArrayList<Double> countRoot(double a, double b, double discriminant) {
        ArrayList<Double> list = new ArrayList<>();
        double pom = (-b + Math.sqrt(discriminant)) / 2 * a;
        if (pom == 0) {
            pom = Math.abs(pom);
        }
        list.add(pom);

        pom = (-b - Math.sqrt(discriminant)) / 2 * a;
        if (pom == 0) {
            pom = Math.abs(pom);
        }
        list.add(pom);
        return list;
    }

    public String solve(double a, double b, double c) {
        Solutions statements = new Solutions();
        double squareDiscriminant;
        String report;
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    report = statements.identityEquation();
                } else {
                    report = statements.inconsistantEquation();
                }
            } else {
                double x = -c / b;
                if (x == 0) {
                    x = Math.abs(x);
                }
                report = statements.linearEquation(x);
            }
        } else {
            squareDiscriminant = countSquareDiscriminant(a, b, c);
            if (squareDiscriminant < 0) {
                report = statements.quadraticEquation(squareDiscriminant);
            } else if (squareDiscriminant == 0) {
                report = statements.quadraticEquation(
                        countRoot(a, b, squareDiscriminant).get(0), squareDiscriminant);
            } else {
                ArrayList<Double> solutions = countRoot(a, b, squareDiscriminant);
                report = statements.quadraticEquation(solutions.get(0),
                        solutions.get(1), squareDiscriminant);
            }
        }
        return report;
    }
}
