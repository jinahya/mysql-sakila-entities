-- --------------------------------------------------------------------------------------------- select special_features
SELECT special_features
FROM film;


SELECT f.film_id, fc.category_id
FROM film AS f
         LEFT OUTER JOIN film_category AS fc ON f.film_id = fc.film_id OR fc.film_id IS NULL
-- WHERE fc.category_id IS NULL
ORDER BY f.film_id
;