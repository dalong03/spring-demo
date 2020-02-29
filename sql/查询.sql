use fb;
#用户
select * from sys_user where 1=1;
#日志
SELECT 
    *
FROM
    sys_log t
WHERE
    1 = 1
        AND DATE_FORMAT(t.create_date, '%Y%m%d') = '20190311'
ORDER BY t.create_date DESC;
#字典
SELECT 
    *
FROM
    sys_dict
WHERE
    1 = 1 
    #AND pid = 50
ORDER BY sort;
#用户
SELECT 
    *
FROM
    sys_user
    order by create_time;
#角色
SELECT 
    *
FROM
    sys_role
    ORDER BY sort;
#关系
SELECT 
    *
FROM
    sys_relation;
#菜单
SELECT 
    *
FROM
    sys_menu t
    where 1=1
    and t.code like '%menu%'
    order by t.sort;