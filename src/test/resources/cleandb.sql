delete from artist_location;
delete from artist;
delete from location;
insert into location Values (1, 'US', 'WI', 'Madison'), (2, 'US', 'WI', 'Stevens Point'), (3, 'US', 'WI', 'Green Bay');
insert into artist Values ('5L3STwlqP4cN3E9rMWES48', 'Good Grief'), ('1f0MVS6tmwuV6j1uwbriC9', 'Heavy Looks'), ('3KDhIfgNvDwSVflsZR42jD', 'Holly and the Nice Lions');
insert into artist_location Values ('5L3STwlqP4cN3E9rMWES48', 1), ('5L3STwlqP4cN3E9rMWES48', 2), ('3KDhIfgNvDwSVflsZR42jD', 3), ('3KDhIfgNvDwSVflsZR42jD', 1), ('1f0MVS6tmwuV6j1uwbriC9', 1);