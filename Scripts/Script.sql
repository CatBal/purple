select f.name, f.description, s.name
from forum f
join "subscription" sn
using (forum_id)
join subscriber s 
using (subscriber_id);



select s.name, m.text, f.name 
from forum f
join message m 
using (forum_id)
join subscriber s 
using (subscriber_id);


select s.name, s.password
from subscriber s;


