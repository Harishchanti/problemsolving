package LLD.rateLimiter;
/*

// ===================== Strategy Pattern =====================
 */
public interface RateLimiterStrategy {
    boolean allowRequest(String key);
}
