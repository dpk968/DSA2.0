CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
# SET N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
        # SELECT DISTINCT salary FROM Employee ORDER BY salary DESC LIMIT 1 offset N

        select salary from (select distinct salary,DENSE_RANK() over (order by salary desc) as ranke from Employee) t where ranke = N 

  );
END