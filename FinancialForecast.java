public class FinancialForecast {
    public static double forecast(double currentAmount, double growthRate, int years) {
        if (years == 0) {
            return currentAmount;
        }
        return forecast(currentAmount * (1 + growthRate), growthRate, years - 1);
    }
    public static void main(String[] args) {
        double initialInvestment = 10000.0; 
        double annualGrowthRate = 0.10; 
        int years = 5;
        double futureValue = forecast(
                initialInvestment,
                annualGrowthRate,
                years
        );
        System.out.printf("Initial Investment : ₹%.2f%n", initialInvestment);
        System.out.printf("Growth Rate        : %.0f%%%n", annualGrowthRate * 100);
        System.out.println("Years              : " + years);
        System.out.printf("Forecast Value     : ₹%.2f%n", futureValue);
    }
}