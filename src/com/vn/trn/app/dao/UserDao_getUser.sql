SELECT
	 UM.id AS user_key
	 UM.user_name AS user_name
FROM
	user_master UM
WHERE
	UM.user_name = /*user_name*/
AND	UM.password = /*password*/
