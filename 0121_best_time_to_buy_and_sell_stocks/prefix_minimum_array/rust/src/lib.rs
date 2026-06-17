pub fn max_profit(prices: &[i32]) -> i32 {
    let mut prefix_min = vec![0; prices.len()];
    prefix_min[0] = prices[0];

    for i in 1..prices.len() {
        prefix_min[i] = prefix_min[i - 1].min(prices[i]);
    }

    prices
        .iter()
        .zip(prefix_min.iter())
        .map(|(&price, &buy_price)| price - buy_price)
        .max()
        .unwrap_or(0)
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
