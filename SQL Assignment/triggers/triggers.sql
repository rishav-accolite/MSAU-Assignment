show databases;
use demo;
create table Department(d_id integer not null auto_increment primary key,dept_name varchar(50),dept_head varchar(50));
create table Employee(eid integer not null auto_increment primary key ,first_name varchar(20), last_name varchar(20), d_id integer,foreign key(d_id) references department(d_id));
insert into department(dept_name,dept_head) values('Computer Enginnering','Mayank Dave');
insert into department(dept_name,dept_head) values('Mechanical Engineering','Rajeev Verma');
insert into department(dept_name,dept_head) values('Electrical Enginnering','Alpha Dave');
insert into department(dept_name,dept_head) values('Electronics Enginnering','Beta Dave');
insert into department(dept_name,dept_head) values('Civil Enginnering','Gamma Dave');

select * from department;


insert into Employee(first_name,last_name) values('Rishav','Gupta');
insert into Employee(first_name,last_name,d_id) values('Kushmeet','Singh',1);
insert into Employee(first_name,last_name,d_id) values('Vivek','Singh',1);
insert into Employee(first_name,last_name,d_id) values('Prashant','Samadhiya',5);
insert into Employee(first_name,last_name,d_id) values('Raju','Srivastava',3);
insert into Employee(first_name,last_name,d_id) values('Anadi','Bajpayee',4);
insert into Employee(first_name,last_name) values('raju','rastogi');
insert into Employee(first_name,last_name) values('ranchoddas','chanchad');
insert into Employee(first_name,last_name) values('Farhan','');

select * from employee;

select eid,first_name,last_name,e.d_id,dept_name,dept_head
from employee e join department d on e.d_id=d.d_id;

select eid,first_name,last_name,e.d_id,dept_name,dept_head
from employee e left join department d on e.d_id=d.d_id;

select eid,first_name,last_name,d.d_id,dept_name,dept_head
from employee e right join department d on e.d_id=d.d_id;

select d.dept_name as "Department Name",count(e.eid) as "No. Of Employees"
from employee e right join department d on e.d_id=d.d_id
group by d.dept_name;

create table employee_audit(s_no integer not null auto_increment primary key,eid integer,last_name varchar(100),action varchar(100),change_date date);
select * from employee_audit;
delimiter $$
create trigger before_employee_update before update on employee
for each row

begin
	insert into employee_audit
    set action='update',
    eid=OLD.eid,
    last_name=Old.last_name,
    change_date=NOW();
end$$


select * from employee;
update employee set last_name='Kumar Gupta' where eid=1;

select * from employee_audit;

Drop trigger if exists employee.before_employee_update;

select * from employee_audit;

delimiter $$
create procedure selectAllEmployees(in dept_name varchar(100))
begin
select e.first_name from employee e join department d on e.d_id=d.d_id
where d.dept_name=dept_name;
end$$
call selectAllEmployees('Computer Enginnering');



select* from department;

show databases;
use demo;
show tables;
SHOW TRIGGERS;

delimiter $$
create trigger after_employee_update after update on employee
for each row

begin
	insert into employee_audit
    set action='After Update',
    eid=new.eid,
    last_name=new.last_name,
    change_date=NOW();
end$$


delimiter $$
create trigger before_employee_insert before insert on employee
for each row

begin
	insert into employee_audit
    set action='Before Insert',
    eid=new.eid,
    last_name=new.last_name,
    change_date=NOW();
end$$
delimiter $$
create trigger after_employee_insert after insert on employee
for each row

begin
	insert into employee_audit
    set action='After Insert',
    eid=new.eid,
    last_name=new.last_name,
    change_date=NOW();
end$$

delimiter $$

create trigger before_employee_delete before delete on employee
for each row

begin
	insert into employee_audit
    set action='Before delete',
    eid=old.eid,
    last_name=old.last_name,
    change_date=NOW();
end$$

delimiter $$

create trigger After_employee_delete after delete on employee
for each row

begin
	insert into employee_audit
    set action='After delete',
    eid=old.eid,
    last_name=old.last_name,
    change_date=NOW();
end$$

show triggers;



insert into Employee(first_name,last_name,d_id) values('Akshay','Gaitonde',4);

update employee set last_name="Gaikwad" where eid=11;
select * from Employee;
delete from employee where eid=12;

select * from employee_audit;





