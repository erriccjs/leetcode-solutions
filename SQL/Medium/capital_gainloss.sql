-- Problem Link: https://leetcode.com/problems/capital-gainloss/description/

-- # Write your MySQL query statement below

SELECT
  stock_name,
  SUM((operation = 'Sell') * price) - SUM((operation = 'Buy') * price)
    AS capital_gain_loss
FROM Stocks
GROUP BY stock_name;