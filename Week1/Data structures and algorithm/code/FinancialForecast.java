public class FinancialForecast {

    // Recursive method to calculate future value
    public static double futureValue(double principal, double rate, int years) {
        if (years == 0) {
            return principal;
        }
        return futureValue(principal, rate, years - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        double initialAmount = 10000; // Principal
        double annualGrowthRate = 0.05; // 5%
        int years = 5;

        double result = futureValue(initialAmount, annualGrowthRate, years);
        System.out.printf("Future Value after %d years: ₹%.2f\n", years, result);
    }
}
