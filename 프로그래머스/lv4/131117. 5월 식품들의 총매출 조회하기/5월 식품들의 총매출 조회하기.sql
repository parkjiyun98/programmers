-- 코드를 입력하세요
SELECT A.PRODUCT_ID, A.PRODUCT_NAME, SUM(A.PRICE * B.AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT AS A
JOIN FOOD_ORDER AS B
ON A.PRODUCT_ID = B.PRODUCT_ID
WHERE DATE_FORMAT(B.PRODUCE_DATE, "%Y-%m") = "2022-05" 
GROUP BY A.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, PRODUCT_ID ASC