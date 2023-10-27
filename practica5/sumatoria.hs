sumatoria :: Int -> Double
sumatoria 0 = 0.0
sumatoria n = 1 / ((2 * fromIntegral n - 1) * (2 * fromIntegral n - 1)) + sumatoria (n-1)
