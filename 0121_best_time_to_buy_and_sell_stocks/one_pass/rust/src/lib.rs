pub fn max_profit(prices: &[i32]) -> i32 {
    let mut min_price = prices[0];
    let mut best_profit = 0;

    for &price in prices {
        best_profit = best_profit.max(price - min_price);
        min_price = min_price.min(price);
    }

    best_profit
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn profitable_swing() {
        assert_eq!(max_profit(&[7, 1, 5, 3, 6, 4]), 5);
    }

    #[test]
    fn decreasing_prices() {
        assert_eq!(max_profit(&[7, 6, 4, 3, 1]), 0);
    }

    #[test]
    fn single_price() {
        assert_eq!(max_profit(&[5]), 0);
    }

    #[test]
    fn two_increasing() {
        assert_eq!(max_profit(&[1, 2]), 1);
    }

    #[test]
    fn two_decreasing() {
        assert_eq!(max_profit(&[2, 1]), 0);
    }

    #[test]
    fn best_sale_before_later_low() {
        assert_eq!(max_profit(&[2, 4, 1]), 2);
    }

    #[test]
    fn multiple_valleys() {
        assert_eq!(max_profit(&[3, 2, 6, 5, 0, 3]), 4);
    }

    #[test]
    fn all_equal() {
        assert_eq!(max_profit(&[5, 5, 5]), 0);
    }

    #[test]
    fn zero_price() {
        assert_eq!(max_profit(&[0, 4, 0, 10]), 10);
    }
}
