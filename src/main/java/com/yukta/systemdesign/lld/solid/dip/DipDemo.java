package com.yukta.systemdesign.lld.solid.dip;

// Interface provided for classes to implement different recommendation strategies
interface RecommendationStrategy {
    void getRecommendations();
}

// Class implementing recommendations based on recently added
class RecentlyAdded implements RecommendationStrategy {
    public void getRecommendations() {
        System.out.println("Showing recently added content...");
    }
}

// Class implementing recommendations based on trending now
class TrendingNow implements RecommendationStrategy {
    public void getRecommendations() {
        System.out.println("Showing trending content...");
    }
}

// Class implementing recommendations based on Genre
class GenreBased implements RecommendationStrategy {
    public void getRecommendations() {
        System.out.println("Showing content based on your favorite genres...");
    }
}

// Class implementing the Recommendation Engine (High - level module)
class RecommendationEngine {
    private RecommendationStrategy strategy;

    public RecommendationEngine(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public void recommend() {
        strategy.getRecommendations();
    }
}

// Main driver code
 public class DipDemo  {
    public static void main(String[] args) {
        RecommendationEngine engine = new RecommendationEngine(new TrendingNow());
        engine.recommend();
    }
}


